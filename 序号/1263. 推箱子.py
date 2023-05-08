class Solution:
    def minPushBox(self, grid: List[List[str]]) -> int:
        # 01BFS,求最小推动次数，推动次数为权，bfs用双端队列先遍历无权边，再遍历有权边
        # 找box，person,target
        bi = bj = si = sj = ti = tj = 0

        for i, row in enumerate(grid):
            for j, c in enumerate(row):
                if c == "S":
                    si, sj = i, j
                elif c == "B":
                    bi, bj = i, j
                elif c == "T":
                    ti, tj = i, j

        m, n = len(grid), len(grid[0])

        def xy2i(x,y):
            '''坐标转换成int'''
            return x*n+y
        
        def check(i, j):
            return 0 <= i < m and 0 <= j < n and grid[i][j] != "#"
        
        dirs=(0,-1,0,1,0)
        q=deque()
        vis=[[False]*(m*n) for _ in range(m*n)] # vis[i][j] i表示box坐标  j表示人坐标
        vis[xy2i(bi,bj)][xy2i(si,sj)]=True
        q.append((xy2i(bi,bj),xy2i(si,sj),0))
        def bfs():
            while q:
                b,s,step=q.popleft() #  箱子坐标 、人坐标、推动次数
                bi,bj,si,sj=b//n,b%n,s//n,s%n # 还原坐标 
                if bi==ti and bj==tj: # 到目的了
                    return step
                for i in range(4): # 队列开头状态的下一状态（与当前点连接的边）
                    dx,dy=dirs[i],dirs[i+1] # 偏移量
                    sx,sy,bx,by=si+dx,sj+dy,bi+dx,bj+dy # 新的坐标
                    nb,ns=xy2i(bx,by),xy2i(sx,sy)
                    if check(sx,sy) : # 新的人的坐标能走，且没走过         
                        if sx==bi and sy==bj :  # 走到箱子处了，且箱子可以移动
                            if check(bx,by) and not vis[nb][ns]:
                                vis[nb][ns]=True
                                q.append((nb,ns,step+1))
                        else:
                            if not vis[b][ns]:
                                vis[b][ns]=True
                                q.appendleft((b,ns,step))
            return -1              
        return bfs()