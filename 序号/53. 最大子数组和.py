class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[0]*(n+1)
        ans=-math.inf
        for i ,x in enumerate(nums):
            dp[i+1]=max(x,x+dp[i])
            ans=max(ans,dp[i+1])
        return ans