class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        m,n = len(grid),len(grid[0])
        ans=[]
        for i in range(n):
            x=0
            for j in range(m):
                print(i,j)
                x=max(x,len(str(grid[j][i])))
            ans.append(x)
        return ans