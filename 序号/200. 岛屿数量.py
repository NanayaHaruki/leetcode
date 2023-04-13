class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # dfs
        m, n = len(grid), len(grid[0])
        s = set([(i, j) for j in range(n) for i in range(m) if grid[i][j] == '1'])
        d={(1,0),(-1,0),(0,1),(0,-1)}
        ans=0
        def dfs(r,c):
            if r<0 or r>=m or c<0 or c>=n or grid[r][c]!='1':
                return
            grid[r][c]='2'
            if (r,c) in s:s.remove((r,c))
            for dx,dy in d:
                dfs(r+dx,c+dy)
        
        while s:
            ans+=1
            x,y=s.pop()
            dfs(x,y)
        return ans
        # bfs
        # m, n = len(grid), len(grid[0])
        # s = set([(i, j) for j in range(n) for i in range(m) if grid[i][j] == '1'])
        # d={(1,0),(-1,0),(0,1),(0,-1)}
        # ans=0
        # while s:
        #     x,y = s.pop()
        #     q=deque([(x,y)])
        #     grid[x][y]=-1
        #     ans+=1
        #     while q:
        #         sz=len(q)             
        #         for _ in range(sz):
        #             r,c=q.popleft()
        #             for dx,dy in d:
        #                 nx,ny=r+dx,c+dy
        #                 if 0<=nx<m and 0<=ny<n and grid[nx][ny]=='1':
        #                     grid[nx][ny]='-1'
        #                     s.remove((nx,ny))
        #                     q.append((nx,ny))
        # return ans