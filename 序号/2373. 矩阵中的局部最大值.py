class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        ans = []
        mx=0
        for i in range(1,n-1):
            row=[]
            for j in range(1,n-1):
                mx=max(grid[r][c] for r in range(i-1,i+2) for c in range(j-1,j+2))
                row.append(mx)
            ans.append(row)
        return ans