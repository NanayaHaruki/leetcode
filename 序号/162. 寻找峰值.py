class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r=-1,len(nums)
        if r==1:return 0
        while l+1<r:
            mid=(l+r)//2
            if mid==len(nums)-1 or nums[mid]>nums[mid+1]:
                r=mid
            else: # 题目保证了不可能相等
                l=mid
        return r
    # def findPeakElement(self, nums: List[int]) -> int:
    #     n=len(nums)
    #     if n==1:
    #         return 0
    #     l,r=-1,n
    #     while l+1<r:
    #         m=(l+r)//2
    #         if m==n-1:
    #             return m
    #         if nums[m]>nums[m+1]:
    #             r=m
    #         else:
    #             l=m
    #     return r