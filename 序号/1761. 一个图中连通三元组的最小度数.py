class Solution:
    def minTrioDegree(self, n: int, edges: List[List[int]]) -> int:
        # 建图,统计度数
        g=[[0]*(n+1) for _ in range(n+1)]
        d=[0]*(n+1)
        idces=[x for x in range(n+1)]
        for x,y in edges:
            g[x][y]=1
            g[y][x]=1
            d[x]+=1
            d[y]+=1  
        # 根据度数排序
        idces.sort(key=lambda x:d[x])
        ans=math.inf
        for i in range(1,n+1):
            a=idces[i] # 从度数小的开始找
            if d[a]-2>=ans:break # 剪
            for j in range(i+1,n+1):
                b=idces[j]        
                if d[a]+d[b]-4>=ans:break # 剪
                if g[a][b]==0:continue # 没连上，往后找
                for k in range(j+1,n+1):
                    c=idces[k]
                    sm=d[a]+d[b]+d[c]-6
                    if sm>=ans:break # 剪
                    if g[a][c]==0 or g[b][c]==0:continue # 没连上 往后找
                    ans=sm
        return ans if ans!=math.inf else -1