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

# 24.7.8   
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        ps = list(accumulate(nums))
        for i in range(len(nums)):
            if i==0:
                if ps[-1]-ps[0]==0:
                    return 0
            else:
                if ps[i]-nums[i]==ps[-1]-ps[i]:
                    return i
        return -1