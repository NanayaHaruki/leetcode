class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        # 建图
        g = [[] for _ in range(n)]
        for a,b,w in roads:
            g[a].append((b,w))
            g[b].append((a,w))
        min=ans=0
        # dis记录0到每个点的最小距离
        dis = [math.inf]*n
        cnt=[0]*n
        cnt[0]=1 # cnt[i] 表示0-i的最短路径有多少条
        dis[0]=0
        q = [(0,0)]
        vis=set()
        while q:
            _,u = heapq.heappop(q)
            if u in vis:continue
            vis.add(u)
            # 从0出发找所有相连的点，更新0到这些点的距离
            for v,w in g[u]:
                if dis[v]>dis[u]+w:
                    dis[v]=dis[u]+w
                    heapq.heappush(q,(dis[v],v))
                    cnt[v]=cnt[u]
                elif dis[v]==dis[u]+w:
                    cnt[v]= cnt[v]+cnt[u]
        return cnt[-1] % 1000_000_007