class Solution:
    def countSubgraphsForEachDiameter(self, n: int, edges: List[List[int]]) -> List[int]:
        '''统计最大间距的子树数量'''
        # floyd 统计两点最短路径
        dis = [[0x3f3f3f3f]*n for _ in range(n)]
        g  =[[] for _ in range(n)]
        for a,b in edges:
            g[a-1].append(b-1)
            g[b-1].append(a-1)
            dis[a-1][b-1]=1
            dis[b-1][a-1]=1
        for i in range(n): # 遍历所有中继点
            for j in range(n): # 遍历所有起始点
                for k in range(n): # 遍历与j连接的终点
                    if j==k:
                        dis[j][k]=dis[k][j]=0
                        continue
                    if dis[j][i]+dis[i][k]<dis[j][k]:
                        dis[j][k]=dis[j][i]+dis[i][k]
        print(dis)
        def dfs(start,end,distance,a,b):
            '''
            start 到 end最大距离distance有多少子树
            在start-end之间，可以某些节点独立分支出去，只要最大长度不超过distance都可以计算入内
            '''
            cnt=1
            for next in g[a]:
                if next != b and (dis[start][next]<distance or (dis[start][next]==distance and next>end)) \
                and (dis[end][next]<distance or (dis[end][next]== distance and next>start)):
                    cnt*=dfs(start,end,distance,next,a)
            if dis[start][a]+dis[end][a]>distance:
                cnt+=1
            return cnt

        ans=[0]*(n-1)    
        for i in range(n):
            for j in range(i+1,n):
                ans[dis[i][j]-1]+=dfs(i,j,dis[i][j],i,-1)
        return ans