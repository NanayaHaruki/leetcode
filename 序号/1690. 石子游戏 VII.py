from itertools import accumulate

class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        n=len(stones)
        s=list(accumulate(stones,initial=0))
        @cache
        def dfs(l,r):
            if l==r:return 0
            # 选左边
            res1=s[r+1]-s[l+1]-dfs(l+1,r)
            # 选右边
            res2=s[r]-s[l]-dfs(l,r-1)
            return max(res1,res2)
        res= dfs(0,n-1)
        del dfs
        return res