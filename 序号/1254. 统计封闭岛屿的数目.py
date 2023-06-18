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
        for i in range(m):
            for j in range(n):
                if grid[i][j]==0 and dfs(i,j):
                    # print(i,j)
                    ans+=1
        return ans