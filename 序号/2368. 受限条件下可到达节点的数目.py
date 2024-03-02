class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        g = [[] for _ in range(n)]
        for a,b in edges:
            g[a].append(b)
            g[b].append(a)
        st = set(restricted)
        ans=1
        def dfs(x,f):
            nonlocal ans
            for y in g[x]:
                if y!=f and y not in st:
                    ans+=1
                    dfs(y,x)
        dfs(0,-1)
        return ans 