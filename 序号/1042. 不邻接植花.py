class Solution:
    def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:
        # 图中每个节点最多3条边
        ans=[0]*n
        # 建图 g[i][j] 
        g=[[] for _ in range(n)]
        for a,b in paths:
            g[a-1].append(b-1)
            g[b-1].append(a-1)
       
        for i in range(n):
            c=15
            for j in range(len(g[i])):
                v=g[i][j] # v是与i相连的点，v如果赋值过了颜色，i需要去除掉这个颜色
                if ans[v]:
                    c=c&~(1<<(ans[v]-1))
            c=c&-c
            if c==4:c=3
            elif c==8:c=4
            ans[i]=c
        return ans