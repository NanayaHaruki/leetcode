import random
from typing import List


class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
      # 求区间和在lower-upper之间的个数
      # 区间查询
      return 0

    def __init__(self, rects: List[List[int]]):
      '''
      不重叠矩形中随机选择点
      遍历rects，计算每个矩形有多少个点，计算出总点数，也就是面积和，在面积和中随机出点，再反推出这个点在哪个矩形的哪个位置
      求面积和，需要完整遍历一次，从随机点反推矩形，还需要求前缀和
      '''
      self.rects = rects
      preSum = [0]*(len(rects)+1)
      for i,rect in enumerate(rects):
        area=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1)
        preSum[i+1]=preSum[i]+area
      self.preSum = preSum



    def pick(self) -> List[int]:
      # 扔3次，第一次决定矩形，后面2次决定坐标 --- 这样是错的，这样每个矩形被选中的概率相等，而题设需要每个点等概率返回，所以面积大的矩形应该占用更高的权重
      # 根据总面积，随机出点
      pointIndex = random.randrange(0,self.preSum[-1])
      # 根据目标点反推矩形，也就100个矩形，二分虽然更快，也快不了多少
      targetRectIndex = 0
      for i in range(1,len(self.preSum)):
        if(self.preSum[i]>pointIndex):
          targetRectIndex=i-1
          break

      rect = self.rects[targetRectIndex]
      diff = pointIndex-self.preSum[targetRectIndex]
      # 把左下角当作第一个点，向右上方找目标点
      width = rect[2]-rect[0]+1
      ans = [0,0]
      ans[0]=rect[0]+diff%width
      ans[1]=rect[1]+diff//width
      # if(ans[0] not in range(rect[0],rect[2]+1)):
      #   print(ans[0],rect[0],diff%width)
      # if(ans[1] not in range(rect[1],rect[3]+1)):
      #   print(ans[1],rect[1],diff//width)
      return ans
