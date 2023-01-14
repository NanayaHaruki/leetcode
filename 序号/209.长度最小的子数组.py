'''
找连续子数组和大于等于target的最小长度
'''
class Solution:
    '''二分 N*logN '''
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # 都是正整数，求子数组和》=target的最小长度
        # 先求前缀和，固定左端点，找出满足条件的右端点，更新最小长度
        n=len(nums)
        pre_sum = [0]*(n+1)
        for i in range(1,n+1):
            pre_sum[i]=pre_sum[i-1]+nums[i-1] # pre_sum[i] 为前i个数的和
        ans=0
        for i in range(n+1):
            l,r=0,n+1
            while l+1<r:
                m=(l+r)//2
                if pre_sum[m]-pre_sum[i]>=target:
                    r=m
                else :
                    l=m
            if r<n+1: #  前r个数- 前i个数之和满足条件 r-i即为最小长度。若r=n+1，说明前缀和中找不到
                if ans:
                    ans=min(ans,r-i)
                else:
                    ans=r-i
        return ans

    '''双指针 N'''
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
      # 双指针锁左右边界，右指针不断往前找，满足条件了，计算长度
      # 左指针右移，满足条件，更新最短长度，不满足条件了，右指针继续右移
      l=r=sum=0
      ans=-1
      while r < len(nums):
        sum+=nums[r]
        if sum >= target:
          while l<r and sum-nums[l]>=target:
            sum-=nums[l]
            l+=1
          ans = min(ans,r-l+1) if ans!=-1 else r-l+1
          print(ans,l,r)
        r+=1    
      return ans

  