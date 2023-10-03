class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i][j][k] 在第i天，j=1表示持有股票 0不持有 k表示完成了几次交易
        n=len(prices)
        dp=[[[-math.inf]*3 for _ in range(2)]for _ in range(n)]
        dp[0][1][0]=-prices[0]
        dp[0][0][0]=0
        for i in range(1,n):
            x=prices[i]
            for k in range(3):   
                dp[i][1][k]=max(dp[i-1][1][k],dp[i-1][0][k]-x)
                dp[i][0][k]=dp[i-1][0][k]
                if k and dp[i-1][1][k-1]+x > dp[i][0][k]:
                    dp[i][0][k] = dp[i-1][1][k-1]+x
                # print(i,k,dp[i][1][k],dp[i][0][k])
        return max(dp[-1][0])