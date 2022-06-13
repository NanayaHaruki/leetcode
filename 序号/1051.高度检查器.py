
from queue import PriorityQueue
from typing import List


class Solution:
    def heightChecker(self, heights: List[int]) -> int:
     # 期望身高非降序，返回不满足条件的个数
     # 小顶堆跑一遍，按照顺序在比对即可
      pq = PriorityQueue()
      for h in heights:
        pq.put(h)
      ans=0
      for h in heights:
        if(h != pq.get()): ans+=1
      return ans

