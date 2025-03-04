from typing import List
from collections import Counter, defaultdict, deque
import math
import itertools
from functools import cache

class Solution:
    def maximumPoints(self, edges: List[List[int]], coins: List[int], k: int) -> int:
        n = len(coins)
        tree = [[] for _ in range(n)]
        for a,b in edges:
            tree[a].append(b)
            tree[b].append(a)
        @cache
        def dfs(f,i,a):
            x = (coins[i]>>a)-k
            y = coins[i]>>(a+1)
            for j in tree[i]:
                if f!=j:
                    x+=dfs(i,j,a)
                    if a<13:
                        y+=dfs(i,j,a+1)
            return max(x,y)
        return dfs(-1,0,0)

s = [1,2,3]
print(sum(i for i in s if i!=2))
a=[[0,1],[1,2],[2,3]]
b=[10,10,3,3]

c = Solution().maximumPoints(a,b,5)
print(c)