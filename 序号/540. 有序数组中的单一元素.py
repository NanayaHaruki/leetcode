class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1:return nums[0]
        l,r=-1,n
        while l+2<r:
            m=(l+r)//2
            if nums[m]==nums[m+1]:
                if m&1:r=m
                else:l=m+1
            else:
                if (m+1)&1:r=m+1
                else:l=m
        return nums[l+1]