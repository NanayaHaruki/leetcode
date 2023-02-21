from typing import List
from collections import deque
import heapq

class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n=len(piles)
        for i in range(n-2,-1,-1):
            piles[i]+=piles[i+1]
        
        @cache
        def dfs(i,M):
            '''
            从i开始拿，最多拿2M个，能拿的最大值 = 从i开始的后缀和 - 对手能拿的最小值
            我拿X个，对手能拿的范围是dfs(i+x,max(M,x))
            '''
            if i+M*2>=n:
                return piles[i]
            return piles[i]-min(dfs(i+x,max(M,x)) for x in range(1,2*M+1))
        
        return dfs(0,1)




i = Solution().minTaps(7,[1,2,1,0,2,1,0,1])
print(i)
