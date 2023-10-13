from typing import List
from collections import defaultdict
import bisect
import sortedcontainers

#2023-10-13
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        # 维护一个有水的湖泊队列，优先处理下一次下雨时间最近的湖泊
        ans = [1] * len(rains)
        q = sortedcontainers.SortedSet()  # 存放天晴的日子
        m = {}  # 存放每个湖下雨的日子
        for i, x in enumerate(rains):
            if x == 0:
                q.add(i)
                continue
            ans[i] = -1  # 下雨天抽不了
            # x湖下雨了，找上次下雨的时间j，再在q中找j天之后的第一个日子
            if x not in m:
                m[x] = i
                continue  # 啥都不干，ans中默认抽1号湖了
            j = m[x]
            k = q.bisect_right(j)
            if k == len(q):
                return []  # 这个湖上次下雨和这次下雨之间没有天晴
            ans[q[k]] = x
            m[x] = i
            q.pop(k)
        return ans
# class Solution:
    # 2023-3-13
    # def avoidFlood(self, rains: List[int]) -> List[int]:
    #     sunnyDay = []
    #     lakes = {}
    #     ans=[-1]*len(rains)
    #     for i,lake in enumerate(rains):
    #         if lake:
    #             if lake in lakes:
    #                 j = lakes[lake] # j 为上一次这个湖下雨的日期
    #                 idx = bisect.bisect_right(sunnyDay,j)
    #                 if idx<len(sunnyDay):
    #                     ans[sunnyDay[idx]]=lake
    #                     sunnyDay.pop(idx)
    #                     lakes[lake]=i
    #                 else:
    #                     return []

    #             else:
    #                 lakes[lake]=i # 将这个湖下雨的日期存起来
    #         else:
    #             sunnyDay.append(i)
    #     for i in sunnyDay:
    #         ans[i]=1
    #     return ans
        