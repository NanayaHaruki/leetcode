class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        # 竖切，让出左边，横切让出上边。 右下是不变的
        # 要满足切出去的有苹果，剩下来的也有苹果，就是合理的
        # 先计算前缀和
        mod = int(1e9 + 7)
        m, n = len(pizza), len(pizza[0])
        ps = [[0] * (n + 1) for _ in range(m + 1)]  # ps[i][j]表示[0,0] 到（i-1,j-1)的苹果数量
        for i in range(m):
            for j in range(n):
                ps[i + 1][j + 1] = (
                    ps[i][j + 1]
                    + ps[i + 1][j]
                    - ps[i][j]
                    + (1 if pizza[i][j] == "A" else 0)
                )

        def query(i1, j1, i2, j2):
            # 求 0，0 到 i,j 苹果数 为ps[i+1][j+1]
            return ps[i2 + 1][j2 + 1] - ps[i2 + 1][j1] - ps[i1][j2 + 1] + ps[i1][j1]
        if k==1:
            return 1 if query(0,0,m-1,n-1) else 0
        @cache
        def dfs(c, i, j):
            if c == 0:
                return 1
            # c 还要切几刀; i,j 左上角的起点
            ans = 0
            for j2 in range(j, n - 1):
                # 在[j,j2]竖切，判断左右是否都有苹果
                if query(i, j, m - 1, j2) and query(i, j2 + 1, m - 1, n - 1):
                    ans = (ans + dfs(c - 1, i, j2 + 1)) % mod
            for i2 in range(i, m - 1):
                if query(i, j, i2, n - 1) and query(i2 + 1, j, m - 1, n - 1):
                    ans = (ans + dfs(c - 1, i2 + 1, j)) % mod
            return ans

        return dfs(k - 1, 0, 0)