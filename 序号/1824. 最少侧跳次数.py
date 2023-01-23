class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n=len(obstacles)
        mx=int(0x3f3f3f3f)
        dp=[1,0,1]
        for i in range(1,n):
            if obstacles[i]:
                dp[obstacles[i]-1]=mx
            mn=min(dp)
            for j in range(3):
                if j!=obstacles[i]-1:
                    dp[j]=min(dp[j],mn+1)
        return min(dp)