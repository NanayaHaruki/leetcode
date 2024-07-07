class Solution:
    def checkMove(self, board: List[List[str]], rMove: int, cMove: int, color: str) -> bool:
        m,n = len(board),len(board[0])
        directions = ((1,0),(1,1),(1,-1),(0,1),(0,-1),(-1,-1),(-1,0),(-1,1))
        for dx,dy in directions:
            x,y=rMove,cMove
            while 0<=x+dx<m and 0<=y+dy<n:
                if board[x+dx][y+dy]=='.':
                    break
                if board[x+dx][y+dy]==color:
                    if abs(x+dx-rMove)>1 or abs(y+dy-cMove)>1:
                        return True
                    else:
                        break
                x,y=x+dx,y+dy
        return False