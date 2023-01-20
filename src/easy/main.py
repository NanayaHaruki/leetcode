from math import ceil
from typing import List

class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if m>len(bloomDay)//k:
            return -1
        l,r,n=0,int(1e9+1),len(bloomDay)
        while l+1<r:
            mid=(l+r)//2
            flowers,cnt=0,0
            for i in bloomDay:
                if i<=mid:
                    flowers+=1
                    if flowers==k:
                        cnt+=1
                        flowers=0
                        if cnt==m:
                            break
                else:
                    flowers=0
            if cnt==m:
                r=mid
            else:
                l=mid
        return r

                    

i=Solution().minDays([7,7,7,7,12,7,7],2,3)
print(i)