class Solution:
    def minOperations(self, nums: List[int]) -> int:
        # 排序 去重后，以某个数x为最小的数，x+n-1 为最大的数，这个范围外的数就是要操作的个数
        # 最小操作数就是[x,x+n-1]的数最多，排序后用二分
        n=len(nums)
        nums = sorted(set(nums))
        ans=0
        for l in nums:
            r=l+n
            ans = max(ans,bisect_left(nums,r)-bisect_left(nums,l))
        return n-ans