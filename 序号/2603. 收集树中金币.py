class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        # 找到靠近叶子的金币节点上面两层作为父节点
        # 拓扑删除普通叶子，拓扑删除金币叶子和父节点的边，如果父节点也是叶子再减掉爷节点到父节点的边
        n=len(edges)+1
        g=[[] for _ in range(n)]
        ind=[0]*n
        for a,b in edges:
            g[a].append(b)
            g[b].append(a)
            ind[a]+=1
            ind[b]+=1
        q=deque()
        # 删除非金币叶子
        for i,d in enumerate(ind):
            if d==1 and coins[i]==0:
                q.append(i)
        totalEdges=n-1
        while q:
            u = q.popleft()
            totalEdges-=1
            for v in g[u]:
                ind[v]-=1
                if ind[v]==1 and coins[v]==0:
                    q.append(v)
        # 删除金币叶子
        for i,d in enumerate(ind):
            if d==1 and coins[i]:
                q.append(i)
        while q:
            u=q.popleft()
            totalEdges-=1 # 删的是金币到父节点的边
            for v in g[u]:
                ind[v]-=1 
                if ind[v]==1:# 父节点变新的叶子，不需要走过来，总边-1
                    totalEdges-=1
        return max(0,totalEdges*2)