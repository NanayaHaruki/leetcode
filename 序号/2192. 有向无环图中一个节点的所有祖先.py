from sortedcontainers import sortedlist
class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        g = [[] for _ in range(n)]
        for u,v in edges:
            g[v].append(u)
        
        def dfs(x):
            vis[x]=True
            for nxt in g[x]:
                if not vis[nxt]:
                    dfs(nxt)
        ans=[]
        for i in range(n):
            vis=[False]*n
            dfs(i)
            cur = []
            for j,v in enumerate(vis):
                if i==j or not v:continue
                cur.append(j)
            ans.append(cur)
        return ans

        
