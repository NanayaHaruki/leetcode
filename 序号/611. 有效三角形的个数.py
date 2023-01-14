class Solution:
    '''固定小边，中边，二分查找最大边 n^2log(n)'''
    def triangleNumber(self, nums: List[int]) -> int:
        # 排序后，从小边开始，两个小边大于第三边，二分找满足条件的最大边位置
        nums.sort()
        n,ans=len(nums),0
        for i  in range(n-2):
            for j in range(i+1,n-1):
                l,r=j,n
                while l+1<r:
                    m=(l+r)//2
                    if nums[i]+nums[j]>nums[m]:
                        l=m
                    else:
                        r=m
                ans+=(r-j-1)
        return ans

    '''固定最小边i，双指针j,k向右滑动，k滑动到不满足条件时，j继续滑动，最多滑动2n次， n*2n'''
    def triangleNumber(self, nums: List[int]) -> int:
      nums.sort()
      n,ans=len(nums),0
      for i  in range(n-2):
        k=i+2
        for j in range(i+1,n-1):
          while k<n and nums[k]<nums[i]+nums[j]:
            k+=1
          diff = k-j-1
          if  diff>0: # k并不总是在j的右侧，j滑动到k都可能一直不满足条件
            ans+=diff
      return ans 

