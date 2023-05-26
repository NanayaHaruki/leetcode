class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        rows,cols=len(grid),len(grid[0])
        if grid[0][0]!=0:
            return -1
        else:
            if rows==1 and cols==1:
                return 1
        q=deque()
        q.append(0)
        
        dirs=(-1,0,1,0,-1,-1,1,1,-1)
        ans=1
        while q:
            sz=len(q)
            ans+=1
            for _ in range(sz):
                a = q.popleft()              
                x,y=a&255,a>>8
                for i in range(8):
                    nx,ny=x+dirs[i],y+dirs[i+1]
                    if 0<=nx<rows and 0<=ny<cols and grid[nx][ny]==0:
                        if nx==rows-1 and ny==cols-1:
                            return ans
                        print(nx,ny)
                        q.append(nx | (ny<<8))
                        grid[nx][ny]=-1
        return -1