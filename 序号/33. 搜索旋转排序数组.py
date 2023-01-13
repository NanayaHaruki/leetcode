
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        while l < r:
            m = (l + r) >> 1
            if nums[m] > nums[r]:
                l = m + 1
            else:
                r = m 
        if l==0:
            i = bisect.bisect_left(nums, target)
        else:
            if target >= nums[0]:
                i = bisect.bisect_left(nums, target, 0, l)
            else:
                i = bisect.bisect_left(nums, target, l)
        if i < len(nums) and nums[i] == target:
            return i
        else:
            return -1