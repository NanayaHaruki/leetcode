class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        n = len(values)
        g = [[] for _ in range(n)]
        for u,v,t in edges:
            g[u].append((v,t))
            g[v].append((u,t))
        ans = 0
        path = [0]
        def dfs(u,cur_time):
            if cur_time>maxTime:return
            if u==0:
                st = sum(values[i] for i in set(path))
                nonlocal ans
                if st>ans:              
                    ans = st
            for v,t in g[u]:
                path.append(v)
                dfs(v,cur_time+t)
                path.pop()
        dfs(0,0)
        return ans