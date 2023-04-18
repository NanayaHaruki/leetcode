# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        
        ans=[0]
        def dfs(node):
            if not node:
                return None
            mx,mn=node.val,node.val
            
            l= dfs(node.left)
            r=dfs(node.right)
            if l:
                mx=max(mx,l[0])
                mn=min(mn,l[1])
                ans[0]=max(ans[0],abs(l[0]-node.val),abs(l[1]-node.val))
            if r:
                mx=max(mx,r[0])
                mn=min(mn,r[1])
                ans[0]=max(ans[0],abs(r[0]-node.val),abs(r[1]-node.val))
            return (mx,mn)
        dfs(root)
        return ans[0]