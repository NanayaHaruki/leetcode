class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        # 构图
        n = len(edges)+1
        g =[[] for _ in range(n)]
        for a,b,w in edges:
            g[a].append((b,w))
            g[b].append((a,w))
        # dfs遍历 一条联通线上有多少个点符合要求
        def dfs(x,fa,fw):
            cnt = 1 if fw % signalSpeed==0 else 0
            for y,w in g[x]:
                if y==fa:continue
                cnt += dfs(y,x,fw+w)
            return cnt
        # 遍历所有线，新出线的点必定能与之前的所有点两两成对
        ans = [0]*n
        for x,l in enumerate(g):
            s = 0
            for y,w in l:
                cnt=dfs(y,x,w)
                ans[x]+= s*cnt
                s+=cnt
        return ans