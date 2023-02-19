class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        # 蛇只能从上往下 从左往右移动，用三元组(row,col,direction)
        # row 和 col 表示蛇尾所在坐标 direction 0往右 1往下记录当前蛇的状态，bfs求解
        q=deque()
        q.append((0,0,0))
        st = {(0,0,0)}
        rows,cols,steps=len(grid),len(grid[0]),0
        while q:
            sz = len(q)
            while sz:
                (x,y,d)=q.popleft()
                if (x,y,d)==(rows-1,cols-2,0):
                    return steps           
                if d:# 头朝下
                    # 转头
                    if y+1<cols  and not grid[x][y+1]+grid[x+1][y+1] and (x,y,0) not in st:
                        q.append((x,y,0))
                        st.add((x,y,0))
                    # 朝下移动
                    if x+2<rows and not grid[x+2][y] and (x+1,y,1) not in st:
                        q.append((x+1,y,1))
                        st.add((x+1,y,1))
                    # 朝右移动
                    if y+1<cols and not grid[x][y+1]+grid[x+1][y+1] and (x,y+1,1) not in st:
                        q.append((x,y+1,1))
                        st.add((x,y+1,1))
                else:# 头朝右
                    # 转头
                    if x+1<rows and not grid[x+1][y]+grid[x+1][y+1] and (x,y,1) not in st:
                        q.append((x,y,1))
                        st.add((x,y,1))
                    # 朝右移动
                    if y+2<cols and not grid[x][y+2] and (x,y+1,0) not in st:
                        q.append((x,y+1,0))
                        st.add((x,y+1,0))
                    # 朝下移动
                    if x+1<rows and not grid[x+1][y]+grid[x+1][y+1] and (x+1,y,0) not in st:
                        q.append((x+1,y,0))
                        st.add((x+1,y,0))
                sz-=1
            steps+=1
        return -1