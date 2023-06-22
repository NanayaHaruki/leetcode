class Solution:
    def pondSizes(self, land: List[List[int]]) -> List[int]:
        '''0是水 返回池塘大小; 斜着也算连接'''
        def bfs(i,j):
            '''返回与i j 连接的池塘大小'''
            q=deque([(i,j)])
            ans=1
            land[i][j]=1
            while q:
                x,y=q.popleft()
                for dx,dy in dirs:
                    nx,ny=x+dx,y+dy
                    if 0<=nx<m and 0<=ny<n and land[nx][ny]==0:
                        land[nx][ny]=1
                        q.append((nx,ny))
                        ans+=1
            return ans
        
        def dfs(i,j):
            if i<0 or i>=m or j<0 or j>=n or land[i][j]:
                return 0
            land[i][j] =1
            ans=1
            for dx,dy in dirs:
                nx,ny=i+dx,j+dy
                ans+=dfs(nx,ny)
            return ans
        m,n=len(land),len(land[0])
        dirs=[(i,j) for i in range(-1,2) for j in range(-1,2) if i or j]
        ans=[]
        for i in range(m):
            for j in range(n):
                if land[i][j]==0:
                    ans.append(dfs(i,j))
        ans.sort()
        return ans