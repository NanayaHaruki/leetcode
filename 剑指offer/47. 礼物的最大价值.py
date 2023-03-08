class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        # 奇数行，可以全拿
        # 偶数行，奇数列也能全拿
        m,n = len(grid),len(grid[0])
        dp = [[0]*n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                dp[i][j]=grid[i][j]
                if i and j:
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1])+grid[i][j]
                elif i:
                    dp[i][j]=dp[i-1][j]+grid[i][j]
                elif j:
                    dp[i][j]=dp[i][j-1]+grid[i][j]
                else:
                    dp[i][j]=grid[i][j]
        return dp[-1][-1]