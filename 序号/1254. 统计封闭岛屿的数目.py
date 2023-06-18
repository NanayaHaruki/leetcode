class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        
        m,n=len(grid),len(grid[0])
        def dfs(i,j):
            if i<0 or j <0 or i==m or j==n:   
                return False # n能出界，说明经过了边界，且边界是陆地
            if grid[i][j]!=0:
                return True
            grid[i][j]=-1
            a,b,c,d=dfs(i-1,j) ,dfs(i+1,j) ,dfs(i,j-1) ,dfs(i,j+1)
            return a and b and c and d
        ans=0

        diff=(-1,0,1,0,-1)
        def bfs(i,j):
            ret=True
            if i==0 or j==0 or i==m-1 or j==n-1:
                if grid[i][j]!=1:
                    ret=False
            grid[i][j]=-1
            q=deque([(i,j)])
            
            while q:
                x,y=q.popleft()
                for d in range(4):
                    nx,ny=x+diff[d],y+diff[d+1]
                    if nx>=0 and nx<m and ny>=0 and ny<n and grid[nx][ny]==0:        
                        if nx==0 or ny==0 or nx==m-1 or ny==n-1:
                            if grid[nx][ny]!=1:# 边界不是水，一定不行;如果是陆地一定不能被水包围;如果是-1，说明曾经是陆地
                                ret=False # 这个陆地不是答案，与他连接的全都不是答案，不用返回，全部跑完
                        q.append((nx,ny))
                        grid[nx][ny]=-1
            return ret
        for i in range(m):
            for j in range(n):
                if grid[i][j]==0 and bfs(i,j):
                    print(i,j)
                    ans+=1
        return ans