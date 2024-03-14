class Solution:
    def maxArrayValue(self, nums: List[int]) -> int:
        i = len(nums)-1
        ans = 0
        while i>=0:
            j=i-1
            while j>=0:
                if nums[j]<=nums[i]:
                    nums[i]+=nums[j]
                    j-=1
                else:break
            ans=max(ans,nums[i])
            i=j
        return ans