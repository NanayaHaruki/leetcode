class Solution:
    def maxProfit(self, maxK: int, prices: List[int]) -> int:
        # dp[i][j] 表示交易了i次，j=1为持有 0为不持有
        dp=[[-inf]*2 for _ in range(maxK+1)]
        dp[0][0]=0 # 交易0次，不持有时利润为0，其他情况都不存在，设-inf
        for x in prices:
            for k in range(maxK+1):
                dp[k][1]=max(dp[k][1],dp[k][0]-x)
                if k and dp[k-1][1]+x>dp[k][0]:
                    dp[k][0]=dp[k-1][1]+x
        ans=0
        for x,y in dp:
            ans=max(ans,x,y)
        return ans