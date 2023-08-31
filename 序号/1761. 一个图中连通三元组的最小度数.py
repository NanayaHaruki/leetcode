class Solution:
    def minTrioDegree(self, n: int, edges: List[List[int]]) -> int:
        # 建图;
        # 从点a连接的点中遍历到点b，找b的联通点里 和点a连接的c  abc就是连通三元组;
        # 检查这3个点的度数，求和; 更新最小答案
        g=[[0]*(n+1) for _ in range(n+1)]
        d=[0]*(n+1)
        idces=[x for x in range(n+1)]
        for x,y in edges:
            g[x][y]=1
            g[y][x]=1
            d[x]+=1
            d[y]+=1  
        idces.sort(key=lambda x:d[x])
        ans=math.inf
        for i in range(1,n+1):
            a=idces[i]
            if d[a]-2>=ans:break
            for j in range(i+1,n+1):
                b=idces[j]        
                if d[a]+d[b]-4>=ans:break
                if g[a][b]==0:continue
                for k in range(j+1,n+1):
                    c=idces[k]
                    sm=d[a]+d[b]+d[c]-6
                    if sm>=ans:break
                    if g[a][c]==0 or g[b][c]==0:continue
                    ans=sm
        return ans if ans!=math.inf else -1