class Solution:
    def maximumPoints(self, edges: List[List[int]], coins: List[int], k: int) -> int:
        n = len(coins)
        tree = [[] for _ in range(n)]
        for a,b in edges:
            tree[a].append(b)
            tree[b].append(a)
        @cache
        def dfs(f,i,a):
            x = (coins[i]>>a)-k
            y = coins[i]>>(a+1)
            for j in tree[i]:
                if f!=j:
                    x+=dfs(i,j,a)
                    if a<13:
                        y+=dfs(i,j,a+1)
            return max(x,y)
        return dfs(-1,0,0)
    