class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        # 双指针，快指针f尽量向右扩大长度，如果操作次数不够了，慢指针右移缩短长度
        nums.sort()
        n=len(nums)
        slow=fast=sum=0
        while fast<n:
            sum+=nums[fast]
            if nums[fast]*(fast-slow+1)-sum>k:
                sum-=nums[slow]
                slow+=1 
                #不需要一直移动slow，因为之前长度是满足条件的，fast右移后不满足了，就保持长度继续右移判断有没有更大的长度即可
            fast+=1
        return fast-slow # 应该是fast-slow+1 ，但fast越界了，真正的有效fast应该是fast-1， +1和-1 抵消
    # def maxFrequency(self, nums: List[int], k: int) -> int:
    #     nums.sort()
    #     # 最多出现频次就是将比i小的数，增到i，排序后，让一个区间内所有数都是i
    #     # 总和为 i*len ，可以用前缀和快速算出某个长度需要的操作次数，二分求最大长度
    #     n=len(nums)
    #     l,r=0,n+1
    #     pre = [0]*(n+1)
    #     for i in range(1,n+1):
    #         pre[i]=pre[i-1]+nums[i-1]
    #     while l+1<r:
    #         m=(l+r)//2
    #         f=False
    #         for i in range(m-1,n):
    #             target_sum = nums[i]*m
    #             pre_sum=pre[i+1]-pre[i+1-m]
    #             if target_sum-pre_sum<=k:
    #                 f=True
    #                 break
    #         if f:l=m
    #         else:r=m
    #     return l