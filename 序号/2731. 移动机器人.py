class Solution:
    def sumDistance(self, nums: List[int], s: str, d: int) -> int:
        for i,x in enumerate(nums):
            if s[i]=='L':
                nums[i]-=d
            else:
                nums[i]+=d
        nums.sort()
        ans,mod,n=0,1000_000_007,len(nums)
        for i,x in enumerate(nums):
            # 左边有i个数，计算距离是 nums[i]-nums[0],nums[i]-nums[1],nums[i]要计算i次
            # 右边有n-1-i个数，计算时 nums[j]-nums[i],nums[i+2]-nums[i]，-nums[i]要出现n-1-i次
            # ans+=(i-(n-1-i))*x%mod
            ans+=(2*i-n+1)*x
        return ans%mod