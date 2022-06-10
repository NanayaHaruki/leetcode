from typing import List

class Solution:

    def __init__(self) -> None:
       self.tree = [0]*300030
       self.n = 0 #BIT的大小，离散化的时候更新

    def lowBit(self,i):
      return i & -i

    def update(self,i,j):
      '将i位置增加j,即前缀和为i的子区间数量+1'
      while(i<=self.n):
        self.tree[i]+=j
        i+=self.lowBit(i)

    def query(self,i):
      '查询前缀和<=i的位置有多少个'
      k = 0
      while(i>0):
        k+=self.tree[i]
        i-=self.lowBit(i)
      return k

    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
      # 求 和在lower-upper之间的子区间个数
      # 区间查询 求出前缀和，可以在O1时间判定子区间和，在求前缀和过程中，包括i在内的子区间和的合法数量为preSum[i]-upper,preSum[i]-lower
      # 例：nums = [1 2 3 4]
      # preS = [1 3 6 10] ,lower=4 upper=7的话， i=3，即包括4的前缀和只有[4][3,4][2,3,4][1,2,3,4]
      # 合法子区间个数为 在[0-i]中有几个前缀和为3的，就有几个包括4的和为7的子区间；有几个前缀和为4的，就有几个包括4的区间和为6的子区间...
      # 所以包括4的满足要求的子区间个数，这个问题等价于前缀和在[preSum[i]-upper,preSum[i]-lower]的个数
      # 用树状数组存储前缀和，在此过程中，不断查询满足条件的[preSum[i]-upper,preSum[i]-lower]的个数
      # 所以在树状数组的更新和查询中，需要用到preSum[i]  preSum[i]-upper  preSum[i]-lower
      # 因为值域极大（num[i]为整个int区间，前缀和就超出了，加上要减去upper可能还有负数），所以将需要用到的3个数离散化，因numLen<10^5,故最多用到3*10^5个数。就可以将大于int整个区间的值域压缩到10^5

      # 求前缀和，找出BIT需要用到的3个数
      keys = {0}
      sum = 0
      for num in nums:
        sum+=num
        keys.add(sum)
        keys.add(sum-upper)
        keys.add(sum-lower)

      # 离散化
      list = []
      list.extend(keys)
      list.sort()
      indexOfTree = 1
      d = {}
      for i in list:
        d[i]=indexOfTree
        indexOfTree+=1
      self.n=indexOfTree

      sum=ans=0
      self.update(d[0],1)
      for num in nums:
        sum+=num
        l=self.query(d[sum-upper]-1)
        r=self.query(d[sum-lower])
        ans+=r-l
        self.update(d[sum],1)

      return ans


