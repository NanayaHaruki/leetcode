class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        cuts.append(0)
        cuts.append(n)
        cuts.sort()
        @cache
        def dfs(i,j):
            a,b = bisect_right(cuts,i),bisect_left(cuts,j)
            if a==b:return 0 
            ans = inf
            for c in range(a,b):
                ans = min(ans,dfs(i,cuts[c])+dfs(cuts[c],j)+j-i)
            return ans
        return dfs(0,n)