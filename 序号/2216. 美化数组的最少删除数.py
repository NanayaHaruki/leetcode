class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        l,r,ans,n=0,1,0,len(nums)
        while r<n:
            if nums[l]==nums[r]:
                l,r=l+1,r+1
                ans+=1
            else:
                l,r=l+2,r+2
        ans+=r==n # 说明l在最后一个，需要删掉
        return ans