class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        g=[[]for _ in range(n)]
        # 建表 只需要遍历，不需要随机查边，用临接表存储
        for u,v in edges:
            g[u].append(v)
            g[v].append(u)
        sz=[0]*n
        ans=[0]*n
        # 计算0节点与所有边的和，同时统计所有节点大小
            # 不断往下遍历，就不用标记vis了，带上父节点参数
        def dfs(x,f,d):
            ans[0]+=d # 遍历到x了，增加0到x的距离
            for y in g[x]:
                if y==f:continue
                dfs(y,x,d+1)
                sz[x]+=sz[y] # 上面的dfs会统计y的节点数量
            sz[x]+=1

        dfs(0,-1,0)
        # 换底dp，根据节点与0的关系，计算该节点的和
        def dfs2(x,f):
            for y in g[x]:
                if y==f:continue
                ans[y]=ans[x]+n-sz[y]-sz[y]
                dfs2(y,x)
        dfs2(0,-1)
        return ans