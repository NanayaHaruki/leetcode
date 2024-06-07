class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        n = len(nums)
        o = nums[0]+nums[1]
        ans=1
        for i in range(3,n,2):
            if nums[i]+nums[i-1]==o:
                ans+=1
            else:
                break
        return ans