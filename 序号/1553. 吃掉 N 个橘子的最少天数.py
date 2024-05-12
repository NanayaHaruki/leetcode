class Solution:
    def minDays(self, n: int) -> int:
        @cache
        def dfs(n):
            if n<2:return n
            # 能用除法优先用除法
            # 余几就用吃几个的方式，将n变成2或3的倍数
            ans = n%2+dfs(n//2)
            ans = min(ans,n%3+dfs(n//3))
            return ans+1
        return dfs(n)