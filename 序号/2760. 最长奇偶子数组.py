class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        n=len(nums)
        ans=0
        l=r=0
        while l<n and nums[l]%2:l+=1
        r=l
        while r<n:
            if nums[r]<=threshold and \
            (((r-l)%2==0 and  nums[r]%2==0) or \
            ((r-l)%2==1 and nums[r]%2==1)):
                r+=1
                continue
            # 不满足了，更新答案
            ans=max(ans,r-l)
            l+=1
            while l<n and nums[l]%2:l+=1
            r=l
        ans=max(ans,r-l)
        return ans