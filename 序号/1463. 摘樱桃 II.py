class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        m,n=len(grid),len(grid[0])
        # f[k][c1][c2] 为走了k步，一个在c1列，一个在c2列时，所摘最大数量
        f = [[[0]*n for _ in range(n)] for _ in range(m)]
        f[0][0][-1]=grid[0][0]+grid[0][-1]
        ans=0
        for k in range(1,m): # 只能往下走不能平移，所以走了几步，row就在哪
            for c1 in range(0,min(n,k+1)):
                for c2 in range(max(c1+1,n-k-1),n):
                    # 动态规划，每个机器人有3种移动方式，共有9种转移情况
                    # 1号往左下走，2号往左下
                    p = 0
                    if c1+1 < n:
                        if c2+1 < n:
                            p=max(p,f[k-1][c1+1][c2+1])
                   
                        p=max(p,f[k-1][c1+1][c2])
                    # 1号左下，2号右下
                        if c2-1>=0:
                            p=max(p,f[k-1][c1+1][c2-1])
                    # --- 1d --
                    # 2号左下
                    if c2+1<n:
                        p=max(p,f[k-1][c1][c2+1])
                    # 1d 2d
                    p=max(p,f[k-1][c1][c2])
                    # 1d 2rd
                    if c2-1>=0:
                        p=max(p,f[k-1][c1][c2-1])
                    # --- 1rd ---
                    if c1-1>=0:
                        if c2+1<n:
                            p=max(p,f[k-1][c1-1][c2+1])

                        p=max(p,f[k-1][c1-1][c2])
                        if c2-1>=0:
                            p=max(p,f[k-1][c1-1][c2-1])
                    # 转移完了，加上现在的坐标能采的数量
                    f[k][c1][c2]=p+grid[k][c1]+grid[k][c2]
                    # print(k,f[k][c1][c2])
                    if k==m-1:
                        ans=max(ans,f[k][c1][c2])
        return ans