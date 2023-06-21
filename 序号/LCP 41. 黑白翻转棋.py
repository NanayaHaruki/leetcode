class Solution:
    def flipChess(self, chessboard: List[str]) -> int:
        def bfs(i,j):
            ''' 在[i,j]落黑子后，可以反转多少白子 如果反转了需要继续判断刚刚成为黑子能否继续反转'''
            q=deque([(i,j)])
            ans=0
            g=[list(row) for row in chessboard]
            g[i][j]='X'
            while q:
                i,j=q.popleft()
                for dx,dy in dirs: # 往8个方向找
                    x,y,tmp,findX =i,j, 0,False  # tmp：找到多少白子 findX 是否这个方向上的白子后方有黑子         
                    while 0<=x+dx<m and 0<=y+dy<n:
                        c = g[x+dx][y+dy]
                        if c=='O': 
                            x,y=x+dx,y+dy
                            tmp+=1
                        elif c=='X':
                            findX=True
                            break
                        else:
                            break
                    if findX and tmp:
                        ans+=tmp
                        while tmp:                          
                            g[x][y]='X'
                            q.append((x,y))
                            tmp-=1
                            x,y=x-dx,y-dy
                  
            return ans

        dirs=((-1,-1),(-1,0),(-1,1),(0,1),(0,-1),(1,0),(1,-1),(1,1))
        m,n=len(chessboard),len(chessboard[0])
        ans=0
        for i in range(m):
            for j in range(n):
                if chessboard[i][j]=='.':
                    ans=max(ans,bfs(i,j))
        return ans