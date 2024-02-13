# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        d=defaultdict(list)
        def dfs(node,r,c):
            if not node:return
            d[c].append((r,node.val))
            dfs(node.left,r+1,c-1)
            dfs(node.right,r+1,c+1)
        dfs(root,0,0)
        sd = sorted(d)
        n=len(sd)
        ans=[]
        for i in range(n):
            v = d[sd[i]]
            v.sort()
            ans.append([x[1] for x in v])
        return ans