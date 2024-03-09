class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        g=[[] for _ in range(n+1)]
        for u,v,w in times:
            g[u].append((v,w))
        q=[(0,k)]
        dis=[math.inf]*(n+1)
        dis[k]=0
        vis=set()
        while q:
            _,u = heapq.heappop(q)
            if u in vis:continue
            vis.add(u)
            for v,w in g[u]:
                if dis[v]>dis[u]+w:
                    dis[v]=dis[u]+w
                    heapq.heappush(q,(dis[v],v))
                    
        maxD = 0
        for i in range(1,n+1):
            if dis[i]==math.inf:
                return -1
            maxD = max(maxD,dis[i])
        return maxD
        