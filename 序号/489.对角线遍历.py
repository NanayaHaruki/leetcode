    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        up = True
        x = y = 0
        ans = []
        m = len(mat)
        n = len(mat[0])
        for i in range(m * n):
            ans.append(mat[x][y])
            if (up):  # 右上
                if (y == n - 1):
                    x += 1
                    up = False  # 到最右边，向下挪
                elif (x == 0):
                    y += 1
                    up = False
                else:
                    x -= 1
                    y += 1
            else:
                if (x == m - 1):
                    y += 1
                    up = True
                elif (y == 0):
                    x += 1
                    up = True
                else:
                    x += 1
                    y -= 1
        return ans