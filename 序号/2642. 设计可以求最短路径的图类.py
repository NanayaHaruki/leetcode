class Graph:

    def __init__(self, n: int, edges: List[List[int]]):
        g = [[] for _ in range(n)]
        for u,v,w in edges:
            g[u].append((v,w))
        self.g=g
        self.n=n
    def addEdge(self, edge: List[int]) -> None:
        u,v,w = edge
        self.g[u].append((v,w))

    def shortestPath(self, s: int, t: int) -> int:
        g = self.g
        dis=[inf]*self.n
        dis[s]=0
        q=[(0,s)]
        vis=set()
        while q:
            _,u = heappop(q)
            if u in vis:continue
            vis.add(u)
            for v,w in g[u]:
                if dis[u]+w<dis[v]:
                    dis[v]=dis[u]+w
                    heappush(q,(dis[v],v))
        return dis[t] if dis[t]!=inf else -1


# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)