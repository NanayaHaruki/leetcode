class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)
        for l in piles:
            for i in range(1,len(l)):
                l[i]+=l[i-1]
        @cache
        def dfs(i,r):
            # 第i个栈，还能拿k个
            if r<=0:return 0
            if i==0:
                if r>len(piles[0]):
                    return piles[0][-1]
                return piles[0][r-1]
            mx = dfs(i-1,r) # 不拿
            for j in range(1,min(len(piles[i]),r)+1):
                mx = max(mx,dfs(i-1,r-j)+piles[i][j-1])
            return mx
        return dfs(n-1,k)