class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        g=[[] for _ in range(n)]
        for u,v,w in edges:
            g[u].append((v,w))
            g[v].append((u,w))
        def dijkstra(x):
            q=[(0,x)]
            dis=defaultdict(lambda:math.inf)
            dis[x]=0
            vis=set()
            while q:
                d,u=heapq.heappop(q)
                if u in vis:continue
                for v,w in g[u]:
                    if dis[u]+w<dis[v]:
                        dis[v]=dis[u]+w
                        heapq.heappush(q,(dis[v],v))
            # 计算x到其他点的距离小于distanceThreshold的数量
            cnt=0
            for d in dis.values():
                if d<=distanceThreshold:
                    cnt+=1
            return cnt
        mxDis=math.inf
        ans=0
        for i in range(n):
            c=dijkstra(i)
            if c<=mxDis:
                mxDis=c
                ans=i
        return ans