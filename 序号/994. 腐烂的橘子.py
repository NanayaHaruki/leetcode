class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        total = 0
      
        q = deque()
        vis=set()
        m,n=len(grid),len(grid[0])
        # 找出所有橘子和腐烂橘子的坐标再bfs
        for i,row in enumerate(grid):
            for j,x in enumerate(row):
                if x>0:total+=1
                if x==2:
                    q.append((i,j))
                    vis.add((i,j))
        lj = len(q)
        dirs=(-1,0,1,0,-1)
        minute = 0
        while q:
            sz = len(q)
            
            for _ in range(sz):
                r,c =q.popleft()
                for d in range(4):
                    nr=r+dirs[d]
                    nc=c+dirs[d+1]
                    if 0<=nr<m and 0<=nc<n:
                        if (nr,nc) in vis:continue
                        if grid[nr][nc]==1:
                            vis.add((nr,nc))
                            q.append((nr,nc))
                            lj+=1
            if q:minute+=1
        return minute if lj==total else -1