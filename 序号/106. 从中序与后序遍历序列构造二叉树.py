# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def dfs(inorder,il,ir,postorder,pl,pr):
            if pl>pr:return None
            root = TreeNode(postorder[pr])
            if pl==pr:return root
            # 根据根节点在中序找到位置从而确定子树长度
            rootIndex = inorder.index(postorder[pr],il,ir+1)
            leftLen,rightLen = rootIndex-il,ir-rootIndex
            leftNode = dfs(inorder,il,rootIndex-1,postorder,pl,pl+leftLen-1)
            rightNode = dfs(inorder,rootIndex+1,ir,postorder,pl+leftLen,pr-1)
            root.left = leftNode
            root.right=rightNode
            return root
        return dfs(inorder,0,len(inorder)-1,postorder,0,len(postorder)-1)