class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        m,n=len(land),len(land[0])
        ans=[]
        for i in range(m):
            for j in range(n):
                # 找起点，该点为1，且左边和上面是0
                if land[i][j]==1 and (i==0 or land[i-1][j]==0) and (j==0 or land[i][j-1]==0):
                    r,c=i,j
                    while r+1<m and land[r+1][c]:r+=1
                    while c+1<n and land[r][c+1]:c+=1
                    ans.append((i,j,r,c))
        return ans