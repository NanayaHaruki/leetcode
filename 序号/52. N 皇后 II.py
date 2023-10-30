class Solution:
    def totalNQueens(self, n: int) -> int:
        ans = [0]
        b = [-1] * n

        def check(i, j):
            for row in range(i): # 只需要检查上面的，最大知道i-1
                col = b[row]  # row col是之前皇后放的位置
                if col == j or abs(row - i) == abs(col - j):
                    return False
            return True

        def dfs(i):
            if i == n:
                ans[0] += 1
                return
            for j in range(n):               
                if check(i, j):
                    b[i] = j
                    dfs(i + 1)
        dfs(0)
        return ans[0]