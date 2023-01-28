class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = -1, n
        while l + 1 < r:
            m = (l + r) // 2
            if nums[m] < nums[r - 1]:
                r = m+1
            elif nums[m] > nums[r - 1]:
                l = m
            else:
                r -= 1
        return nums[r]