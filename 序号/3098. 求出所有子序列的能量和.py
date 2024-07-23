class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
      # 找到所有长度为k的子序列，子序列元素差的最小值之和
      # 定义f[i][k]为[0,i]之间长度为k的子序列 的差的最小值为key,这个值出现次数为v的字典
      n = len(nums)
      nums.sort()
      f=[[Counter() for _ in range(k+1)] for _ in range(n)]
      ans=0
      for i in range(n):
        f[i][1][inf]=1
        for j in range(i):
          diff = nums[i]-nums[j]
          for l in range(2,k+1):
            for mn,cnt in f[j][l-1].items():
              f[i][l][min(diff,mn)]+=cnt
        if i+1>=k:
          for mn,cnt in f[i][k].items():
            ans=(ans+mn*cnt)%1000000007
      return ans
                  
# gosper's hack 超时
# d = {}
# for i in range(50):
#     d[2**i]=i
# class Solution:
#     def sumOfPowers(self, nums: List[int], k: int) -> int:
#         n = len(nums)
#         nums.sort()
       
#         def energy(x):
#             # nums已经排序了，只要检查2个相邻位置之间的差值
#             pre = x&-x
#             x^=pre
#             ans=inf
#             while x:
#                 lb = x&-x
#                 ans=min(ans,nums[d[lb]]-nums[d[pre]])
#                 pre=lb
#                 x^=pre
#             return ans
#         x = (1<<k)-1
#         limit = 1<<n
#         ans = 0
#         while x<limit:
#             ans=(ans+energy(x))% 1000000007
#             lb=x&-x
#             left=x+lb
#             right=(x^left)//lb>>2
#             x=left|right
            
#         return ans