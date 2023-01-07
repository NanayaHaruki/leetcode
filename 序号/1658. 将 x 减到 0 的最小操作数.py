class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        '''从nums两头取值，求最小次数让取值达到x'''
        # 即从nums中间取出和为sum-x的最长区间
        # 先让右区间等于整个数组，大于x则右指针右移来减小总和。当小于x时，左指针右移来增加总和
        target = sum(nums)-x
        s=l=0
        n=len(nums)
        ans=-1
        for r in range(n):
            s+=nums[r]
            while l<n and s>target:
                s-=nums[l]
                l+=1
            if s==target:
                ans=max(ans,r-l+1)
        return -1 if ans<0 else n-ans