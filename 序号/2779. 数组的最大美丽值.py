class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        if nums[0]+k>=nums[-1]-k:return n
        a,b=bisect.bisect_left(nums,nums[0]+k),bisect.bisect_left(nums,nums[-1]-k)
        ans = 0
        for i,x in enumerate(nums):
            j = bisect.bisect_right(nums,x+2*k)
            if j==n:
                return max(ans,n-i)
            if nums[j]==x+2*k:
                j+=1
            ans=max(ans,j-i)
        return ans