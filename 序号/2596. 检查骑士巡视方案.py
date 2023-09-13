class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        if grid[0][0]!=0:return False
        i=x=y=0
        diff={(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)}
        m,n=len(grid),len(grid[0])
        while i<m*n-1: # 5*5 25个格子，编号最大24，i=23的时候进入最后一次循环判断
            findNext=False
            for dx,dy in diff:
                nx,ny=x+dx,y+dy
                if 0<=nx<m and 0<=ny<n and grid[nx][ny]==i+1:
                    i,x,y=i+1,nx,ny
                    findNext=True
                    # print(f'{i} {nx} {ny}')
                    break
            if not findNext:return False
        return True