from typing import List
from collections import deque

class Solution1:

    def minimumMoves(self, g: List[List[int]]) -> int:

        step, n = 1, len(g)

        vis = {(0, 0, 0)}

        q = [(0, 0, 0)]  # 初始位置

        while q:

            tmp = q

            q = []

            for X, Y, S in tmp:
                print(X,Y,S)

                for t in (X + 1, Y, S), (X, Y + 1, S), (X, Y, S ^ 1):  # 直接把移动后的位置算出来

                    x, y, s = t

                    x2, y2 = x + s, y + (s ^ 1)  # 蛇头

                    if x2 < n and y2 < n and t not in vis and g[x][y] == 0 and g[x2][y2] == 0 and (s == S or g[x + 1][y + 1] == 0):
                        if x == n - 1 and y == n - 2:  # 此时蛇头一定在 (n-1,n-1)

                            return step

                        vis.add(t)

                        q.append(t)

            step += 1

        return -1

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

g=[
    [0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,0,1,1,0,0,1,0,0,0,0,1,0,0],
    [0,1,0,0,0,0,1,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,1,1,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,1,0,1,0,0,0],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
    [0,0,0,1,0,1,0,0,1,0,0,0,1,0,0],
    [0,0,0,0,1,0,0,0,0,0,0,0,0,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
    [0,0,0,1,0,0,0,0,0,0,0,0,0,0,0],
    [1,0,1,1,0,0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,1,0],
    [1,0,0,0,0,0,1,0,0,0,1,0,0,0,1],
    [0,0,1,0,1,0,0,0,0,0,0,0,0,0,0]]

i = Solution().minimumMoves(g)
print(i)
                    
                    

        





        


