class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        # f[i][j]为通过第i个路，跳过休息j次的用时
        # 转移方程：i跳了，f[i][j]=f[i-1][j-1]+dist[i]/speed
        # i 不跳 f[i][j]=f[i-1][j]+ceil(dist[i]/speed)
        n=len(dist)
        eps = 1e-7
        f=[[0]*(n+1) for _ in range(n+1)]
        for i in range(1,n+1):# 跳到倒数第2个就行，最后一个不用等待
            for j in range(i+1): 
                if j==0: # 一个没跳，
                    f[i][j]=f[i-1][0]+ceil(dist[i-1]/speed-eps)
                elif j==i: # 全跳了
                    f[i][j]=f[i-1][j-1]+dist[i-1]/speed
                else:
                    f[i][j]=min(ceil(f[i-1][j]+dist[i-1]/speed)-eps,f[i-1][j-1]+dist[i-1]/speed)
        for i in range(n+1):
            if f[n][i]-eps<hoursBefore:
                return i
        return -1