# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def dfs(preorder,pl,pr,inorder,il,ir):
            if pl>pr: return None
            if pl==pr:return TreeNode(preorder[pl])
            mid = preorder[pl]
            midIndex = inorder.index(mid,il,ir+1)
            root=TreeNode(preorder[pl])
            root.left = dfs(preorder,pl+1,pl+midIndex-il,inorder,il,midIndex-1)
            root.right = dfs(preorder,pl+midIndex-il+1,pr,inorder,midIndex+1,ir)
            return root
        return dfs(preorder,0,len(preorder)-1,inorder,0,len(inorder)-1)
            