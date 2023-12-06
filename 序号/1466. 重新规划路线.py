class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        ans=0
        # 建表
        g=[[] for _ in range(n)]
        for a,b in connections:
            g[a].append(b)
            g[b].append(a-n) # 负数表示逆向
        def dfs(cur,fa):
            if len(g[cur])==1 and g[cur]==fa:return # 到叶子了          
            for nxt in g[cur]:
                if nxt>=0:
                    if nxt==fa:continue
                    # print(fa,cur,nxt)
                    nonlocal ans
                    ans+=1
                    dfs(nxt,cur)
                else:
                    if nxt+n==fa:continue
                    dfs(nxt+n,cur)
        dfs(0,-1)
        return ans