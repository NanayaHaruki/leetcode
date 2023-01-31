from typing import List
from collections import defaultdict
import bisect
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        sunnyDay = []
        lakes = {}
        ans=[-1]*len(rains)
        for i,lake in enumerate(rains):
            if lake:
                if lake in lakes:
                    j = lakes[lake] # j 为上一次这个湖下雨的日期
                    idx = bisect.bisect_right(sunnyDay,j)
                    if idx<len(sunnyDay):
                        ans[sunnyDay[idx]]=lake
                        sunnyDay.pop(idx)
                        lakes[lake]=i
                    else:
                        return []

                else:
                    lakes[lake]=i # 将这个湖下雨的日期存起来
            else:
                sunnyDay.append(i)
        for i in sunnyDay:
            ans[i]=1
        return ans
        