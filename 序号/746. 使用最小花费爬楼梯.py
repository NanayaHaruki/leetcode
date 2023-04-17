class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n=len(cost)
        dp=[0]*(n+1)
        for i in range(2,n+1):
            dp[i]=min(dp[i-1]+cost[i-1],dp[i -2]+cost[i-2])
        return dp[n]

        # @cache
        # def dfs(i):
        #     '''跳到i，需要付出的代价'''
        #     if i < 2: 
        #         return 0 # 可以选择从0或1开始，没有代价
        #     return min(dfs(i - 1) + cost[i - 1], dfs(i - 2) + cost[i - 2])
        # return dfs(len(cost))