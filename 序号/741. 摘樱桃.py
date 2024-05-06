class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n=len(grid)
        # 横着竖着都走n-1步，总共2n-2步
        f=[[[-inf]*n for _ in range(n)] for _ in range(2*n-1)]
        f[0][0][0]=grid[0][0]
        # f[k][r][x] 表示走了k步，1人在r行，1人在c行时摘到的最大数
        # 考虑2个人同时走，如果走2遍，2遍最优并非全局最优
        # 定义r走上面，x走下面
        for k in range(1,2*n-1): # 走了k步
            # 走了k步，当k<n时，r属于[0,k]; 
            # 当k==n时，r最少也得是1，往下走1步，往右走n-1，r属于[k-n+1,n-1]
            for r in range(max(0,k-n+1),min(n,k+1)):
                c = k-r  # 往下走了r步，往右走了c步
                if grid[r][c]==-1:continue
                for x in range(r,min(n,k+1)):
                    y=k-x
                    if grid[x][y]==-1:continue
                    # 枚举k-1步所在位置，找最大摘到的数量
                    p = f[k-1][r][x] # 上一步两人就走到这一行了，这次两人都向右
                    if r>0:
                        p=max(p,f[k-1][r-1][x]) # r 向下，x向右
                    if x>0:
                        p=max(p,f[k-1][r][x-1]) # r 向右，x 向下
                    if r>0 and x>0:
                        p=max(p,f[k-1][r-1][x-1])
                    p+=grid[r][c]
                    if r!=x:
                        p+=grid[x][y]
                    f[k][r][x]=p
        return max(0,f[-1][-1][-1])