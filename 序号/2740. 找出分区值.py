class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        # 不就是找最近的2个数吗，把较小的放在nums1，让它是nums1中最大的;让较大的放到nums2中，让它是最小的
        diff = inf
        nums.sort()
        for i in range(len(nums)-1):
            diff = min(diff,nums[i+1]-nums[i])
        return diff