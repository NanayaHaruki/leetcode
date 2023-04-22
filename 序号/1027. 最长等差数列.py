class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[{} for _ in range(n)]
        ans=0
        for i in range(n):
            for j in range(i):
                diff=nums[j]-nums[i]
                if diff in dp[j]:
                    dp[i][diff]=dp[j][diff]+1
                else:
                    dp[i][diff]=2
                ans=max(ans,dp[i][diff])             
        return ans