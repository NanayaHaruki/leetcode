class Solution:
    def minimumTime(self, n: int, edges: List[List[int]], disappear: List[int]) -> List[int]:
        g = [[]  for _ in range(n)]
        for u,v,w in edges:
            g[u].append((v,w))
            g[v].append((u,w))
        q = [(0,0)]
        dis = [inf]*n
        dis[0]=0
        vis=set()
        while q:
            d,u = heapq.heappop(q)
            if u in vis:continue
            vis.add(u)
            for v,w in g[u]:
                if dis[u]<disappear[u] and dis[u]+w<disappear[v] and dis[u]+w<dis[v]:
                    dis[v]=dis[u]+w
                    heapq.heappush(q,(dis[v],v))
        for i in range(n):
            if dis[i] is inf:
                dis[i]=-1
        return dis