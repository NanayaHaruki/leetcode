from math import ceil
from typing import List

class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n=len(obstacles)
        mx=int(2**31-1)
        dp=[[mx for _ in range(3)] for _ in range(n)]
        dp[0][0]=1
        dp[0][1]=0
        dp[0][2]=1
        for i in range(1,n):
            if obstacles[i]:
                dp[i][obstacles[i]-1]=mx
                
            dp[i][0]=min(dp[i-1][0],dp[i-1][1]+1,dp[i-1][2]+1)
            dp[i][1]=min(dp[i-1][1],dp[i-1][0]+1,dp[i-1][2]+1)
            dp[i][2]=min(dp[i-1][2],dp[i-1][0]+1,dp[i-1][1]+1)

            if obstacles[i]:
                dp[i][obstacles[i]-1]=mx
        return min(dp[-1])
            


                    

i=Solution().minSideJumps([0,1,2,3,0])
print(i)