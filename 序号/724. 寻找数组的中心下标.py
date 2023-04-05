class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        sm=sum(nums)
        pre=0
        n=len(nums)
        for i,x in enumerate(nums):
            if pre==sm-pre-x:
                return i
            pre+=x
        return -1