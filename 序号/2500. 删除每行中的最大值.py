class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        for row in grid:
            row.sort()
        m,n=len(grid),len(grid[0])
        ans=0
        for j in range(n-1,-1,-1):
            rowMx=0
            for i in range(m):
                rowMx=max(rowMx,grid[i][j])
            ans+=rowMx
        return ans