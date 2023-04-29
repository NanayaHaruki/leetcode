from typing import List
from collections import Counter, defaultdict, deque
import math
import itertools
from functools import cache

class Solution:
    def equalFrequency(self, word: str) -> bool:
        cnter=Counter(word)
        for c in word:
            cnter[c]-=1
            # 去掉c这个字符，判断剩余字符是否次数相同
            vv=0
            ok=True
            for v in cnter.values():
                if not v:continue
                if not vv:vv=v
                else:
                    if vv!=v:
                        ok=False
                        break
            if ok:
                return True
            cnter[c]+=1
        return False

                 
s = Solution()
args=['cccd',"abcc",
"aazz",
"bac"]
for a in args:
    print(s.equalFrequency(a))