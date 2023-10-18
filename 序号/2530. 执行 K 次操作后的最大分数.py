import sortedcontainers
class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        nums=[-x for x in nums]
        heapq.heapify(nums)
        ans=0
        for _ in range(k):
            ans += nums[0]
            heapq.heapreplace(nums,nums[0]//3)
        return -ans