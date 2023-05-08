class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        # 修改方向，抵达终点的最少修改次数
        dirs = ((0, 0), (0, 1), (0, -1), (1, 0), (-1, 0))
        m, n = len(grid), len(grid[0])
        dp = [[-1] * n for _ in range(m)]  # 访问到[i][j]需要的次数
        q = deque()
        q.append((0, 0, 0))
        dp[0][0] = 0

        def check(i, j):
            return 0 <= i < m and 0 <= j < n

        while q:
            x, y, cnt = q.popleft()
            print(f"{x} {y} {cnt}")
            if x == m - 1 and y == n - 1:
                return cnt
            # 不改
            nx, ny = x + dirs[grid[x][y]][0], y + dirs[grid[x][y]][1]
            if check(nx, ny) and (dp[nx][ny]== -1 or cnt < dp[nx][ny]):
                q.appendleft((nx, ny, cnt))
                dp[nx][ny] = cnt
            # 改
            for i in range(1, 5):
                nx, ny = x + dirs[i][0], y + dirs[i][1]
                if check(nx, ny) and (dp[nx][ny] == -1 or cnt + 1 < dp[nx][ny]):
                    q.append((nx, ny, cnt + 1))
                    dp[nx][ny] = cnt + 1
        return -1