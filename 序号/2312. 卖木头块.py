class Solution:
    def sellingWood(self, m: int, n: int, prices: List[List[int]]) -> int:
        # dp[i][j] 为长为i，宽为j的矩形能获得的最大价值
        dp = [[0]*(n+1) for _ in range(m+1)]
        # 设置初始化价格
        for w,h,p in prices:
            dp[w][h]=p
        for i in range(1,m+1):
            for j in range(1,n+1):
                # dp[i][j] 应该是遍历所有切的位置，每次切的2个部分的价值和的最大值
                for ii in range(1,i//2+1):
                    dp[i][j]=max(dp[i][j],dp[ii][j]+dp[i-ii][j])
                for jj in range(1,j//2+1):
                    dp[i][j]=max(dp[i][j],dp[i][jj]+dp[i][j-jj])
        return dp[-1][-1]