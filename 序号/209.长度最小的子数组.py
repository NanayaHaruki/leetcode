'''
找连续子数组和大于等于target的最小长度
'''
class Solution:
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