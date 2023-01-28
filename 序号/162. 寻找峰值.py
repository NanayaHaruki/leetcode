class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1:
            return 0
        l,r=-1,n
        while l+1<r:
            m=(l+r)//2
            if m==n-1:
                return m
            if nums[m]>nums[m+1]:
                r=m
            else:
                l=m
        return r