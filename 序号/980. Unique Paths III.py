class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        sx,sy,totalLeft=0,0,0
        m,n=len(grid),len(grid[0])
        dirs=(-1,0,1,0,-1)
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    sx,sy=i,j
                elif grid[i][j]==0:
                    totalLeft+=1
        def dfs(i,j,left):
            # 以i，j为起点，还需要走过left个格子，并且能走到终点的路线有几条
            if i<0 or i>=m or j<0 or j>=n or grid[i][j]==-1:
                return 0 # 越界了，或 走到死路了
            if grid[i][j]==2:
                return 0 if left>0 else 1
            grid[i][j]=-1
            ans=0
            for d in range(4):
                dx,dy=dirs[d],dirs[d+1]
                ans+=dfs(i+dx,j+dy,left-1)
            grid[i][j]=0
            return ans
        return dfs(sx,sy,totalLeft+1)