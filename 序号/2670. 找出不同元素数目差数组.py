class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        total = len(set(nums))
        pre = set()
        res=[0]*len(nums)
        for i,x in enumerate(nums):
            pre.add(x)
            res[i]=len(pre)
        pre.clear()
        for i in range(len(nums)-1,-1,-1):
            res[i]-=len(pre)
            pre.add(nums[i])
        return res