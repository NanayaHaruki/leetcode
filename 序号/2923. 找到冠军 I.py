class Solution:
    def findChampion(self, grid: List[List[int]]) -> int:
        ans = 0
        m,n=len(grid),len(grid[0])
        for i in range(m):
            r = 0
            for j in range(n):
                if i==j or grid[i][j]==1:continue
                r+=1
                break
            if r==0:
                return i
        return 0
            