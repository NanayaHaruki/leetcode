class Solution:
    def possibleToStamp(self, grid: List[List[int]], stampHeight: int, stampWidth: int) -> bool:
        m,n=len(grid),len(grid[0])
        s=[[0]*(n+1) for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                s[i+1][j+1]=s[i][j+1]+s[i+1][j]-s[i][j]+grid[i][j]
        t=[[0]*(n+1) for _ in range(m+1)]
        for i in range(stampHeight-1,m):
            for j in range(stampWidth-1,n):
                ii,jj=i-stampHeight+1,j-stampWidth+1
                if s[i+1][j+1]-s[i+1][jj]-s[ii][j+1]+s[ii][jj]==0:
                    t[ii][jj]+=1
                    t[ii][j+1]-=1
                    t[i+1][jj]-=1
                    t[i+1][j+1]+=1
        for i in range(m):
            for j in range(n):
                if i==0 and j==0 :
                    if grid[0][0]==0 and t[0][0]==0:
                        return False
                    continue
                if i==0:
                    t[i][j]+=t[i][j-1]
                elif j==0:
                    t[i][j]+=t[i-1][j]
                else:
                    t[i][j]+=t[i-1][j]+t[i][j-1]-t[i-1][j-1]
                if grid[i][j]==0 and t[i][j]==0:
                    return False
        return True