class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        # 遍历出来所有值，再二分查每个答案，dfs O(n),+nlogN+m*logN
        vals = []
        def dfs(root):
            if not root:return
            dfs(root.left)
            vals.append(root.val)
            dfs(root.right)
        dfs(root)
        ans=[]
        for i,x in enumerate(queries):
            cur = []
            idx = bisect.bisect_right(vals,x)
            cur.append(-1 if idx-1 <0 else vals[idx-1])
            if 0<=idx-1<len(vals) and vals[idx-1]==x:
                cur.append(x)
            elif 0<=idx<len(vals):
                cur.append(vals[idx])
            else:
                cur.append(-1)
            ans.append(cur)
        return ans