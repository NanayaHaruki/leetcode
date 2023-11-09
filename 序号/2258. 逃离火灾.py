class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        # bfs统计人与火到达每个格子的时间，人比火快多少就是可以等待的最大时间
        # 火不可能中途拦截，反证：假设人到达A点需要3分，火到达A需要4分。
        # 若火在A之前的B点拦截了人，那么在火到达B也一定与人的时间相同，这与假设矛盾
        # 统计到达终点，以及左边 上边两个点的时间。因为题目允许人火同到终点，需要分别计算到达终点两条路的时间
        m,n=len(grid),len(grid[0])
        dirs=(-1,0,1,0,-1)
        def bfs(q:deque):
            times=[[-1]*n for _ in range(m)]
            t=0
            while q:
                sz=len(q)
                for _ in range(sz):
                    x,y=q.popleft()
                    times[x][y]=t
                    for i in range(4):
                        dx,dy=dirs[i],dirs[i+1]
                        nx,ny=x+dx,y+dy
                        if 0<=nx<m and 0<=ny<n and grid[nx][ny]==0 and times[nx][ny]<0:
                            q.append((nx,ny))
                t+=1
            return times[-1][-1],times[-2][-1],times[-1][-2]
        
        fires=deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fires.append((i,j))
        pa,pb,pc=bfs(deque([(0,0)]))
        fa,fb,fc=bfs(fires)
        d=fa-pa
        if pa==-1:return -1 # 人到不了
        if fa==-1:return int(10**9) # 火到不了，可以无限等
        if d<0:return -1 # 火比人先到终点，寄
        if pb!=-1 and pb+d<fb:return d # 终点上方的路 人可以走的通，且加上等待的时间都比火先到，可以等d分钟
        if pc!=-1 and pc+d<fc:return d # 终点左边的路 。。。
        return d-1 # 人火一路，人得快一分钟