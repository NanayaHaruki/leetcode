import bisect
from typing import List
import heapq
from sortedcontainers import SortedDict


class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        if len(password)<8:
            return False
        f = set("!@#$%^&*()-+")
        x=0
        pre = ''
        for c  in password:
            if c==pre:
                return False
            pre=c
            if 9>=ord(c)-ord('0')>=0 :
                x=x | 1
            if ord('a')<=ord(c)<=ord('z'):
                x=x | 2
            if ord('A')<=ord(c)<=ord('Z'):
                x=x | 4
            if c in f:
                x=x | 8
        return x==15
            
i=Solution().strongPasswordCheckerII("IloveLe3tcode!")    
print(i)
