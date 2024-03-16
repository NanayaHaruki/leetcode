class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        m,n=len(grid),len(grid[0])
        @cache
        def dfs(row,col):
            if col+1>=n:return 0
            ans=0
            if row-1>=0  and grid[row-1][col+1]>grid[row][col]:
                ans=max(dfs(row-1,col+1)+1,ans)
            if grid[row][col+1] and grid[row][col+1]>grid[row][col]:
                ans=max(ans,dfs(row,col+1)+1)
            if row+1<m and grid[row+1][col+1]>grid[row][col]:
                ans=max(ans,dfs(row+1,col+1)+1)
            return ans
        return max(dfs(r,0) for r in range(m))