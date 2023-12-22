class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # 贪心二分
        # 维护一个list，来个新数字，如果比最后一个大，可以加在list后面，长度+1
        # 如果来个数字比list中最大的那个小，长度不变，但是可以找list中比他大的第一个，替换掉，让list中的元素涨的慢一点
        ans=0
        n=len(nums)
        for i in range(n):
            idx = bisect.bisect_left(nums,nums[i],0,ans)
            if idx==ans:
                ans+=1
            nums[idx]=nums[i]
        return ans
    
    # dp
    def lengthOfLIS(self,nums):
        n=len(nums)
        dp=[0]*n
        for i in range(n):
            for j in range(i):
                if nums[j]<nums[i]:
                    dp[i]=max(dp[i],dp[j])
            dp[i]+=1
        return max(dp)