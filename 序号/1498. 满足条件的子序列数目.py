class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        # 找子序列，让最小值和最大值之和为target，nums中数字有重复，相同值
        n=len(nums)
        nums.sort()
        ans=0
        mod = 1000000007
        for i,x in enumerate(nums):
            if x*2>target:break
            r = bisect.bisect_right(nums,target-x,i+1)
            midNums=r-i-1 # 在[i+1，r-1]内选任选 数字共有 r-1-i-1+1
            ans=(ans+2**midNums)%mod
        return ans