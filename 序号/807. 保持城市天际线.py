class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        m,n = len(grid),len(grid[0])
        maxr,maxc = [0]*m,[0]*n
        for i,row in enumerate(grid):
            maxr[i]=max(row)
        for i in range(n):
            for j in range(m):
                maxc[i]=max(maxc[i],grid[j][i])
        ans = 0
        for i in range(m):
            for j in range(n):
                ans+=min(maxr[i],maxc[j])-grid[i][j]
        return ans