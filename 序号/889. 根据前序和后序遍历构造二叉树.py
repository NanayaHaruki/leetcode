# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> Optional[TreeNode]:
        def dfs(preL,preR,postL,postR):
            if preL>preR or postL>postR:return None
            root=TreeNode(pre[preL])
            if preL==preR:return root
            # 有左子树则是左子树根节点，没左子树就是右子树根节点
            leftRoot = pre[preL+1]
            leftRootIndex = post.index(leftRoot,postL,postR+1)
            leftLen = leftRootIndex-postL+1
            leftNode = dfs(preL+1,preL+leftLen,postL,leftRootIndex)
            rightNode = dfs(preL+leftLen+1,preR,leftRootIndex+1,postR)
            root.left =leftNode
            root.right = rightNode
            return root
        return dfs(0,len(pre)-1,0,len(post)-1)