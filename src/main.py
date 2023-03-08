from typing import List
from collections import Counter,defaultdict
import sys
import time

class Solution:
    def minimumTime(self, s: str) -> int:
        # 用动规统计直接删除或者从一边删到i需要的最小删除次数
        n=len(s)
        lp,rp=[0]*n,[0]*n
        preL,preR=0,0
        for i in range(n):
            if s[i]=='1':
                preL=min(i+1,preL+2) # i+1 是将包括i在内的前面所有全删了 lp[i-1]是之前的次数+直接删除中间需要消耗的2
            if s[n-1-i]=='1':
                preR = min(i+1,preR+2)
            lp[i]=preL
            rp[n-1-i]=preR
        ans=0x3f3f3f3f
        for i in range(n-1):
            ans= min(ans,lp[i]+rp[i+1])
        return min(ans,lp[-1])


i = Solution().minimumTime("000001")
print(i)