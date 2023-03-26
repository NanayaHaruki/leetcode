class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        s=set()
        n=len(nums)
        for i in range(n-1):
            cur=nums[i]+nums[i+1]
            if cur in s:
                return True
            s.add(cur)
        return False