class Solution {

public:

    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>> &edges) {

        vector<vector<int>> g(n);

        for (auto &e : edges) {

            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始

            g[x].push_back(y);

            g[y].push_back(x); // 建树

        }



        int dis[n][n]; memset(dis, 0, sizeof(dis));

        function<void(int, int, int)> dfs = [&](int i, int x, int fa) {

            for (int y : g[x])

                if (y != fa) {

                    dis[i][y] = dis[i][x] + 1; // 自顶向下

                    dfs(i, y, x);

                }

        };

        for (int i = 0; i < n; ++i)

            dfs(i, i, -1); // 计算 i 到其余点的距离



        function<int(int, int, int, int, int)> dfs2 = [&](int i, int j, int d, int x, int fa) {

            // 能递归到这，说明 x 可以选

            int cnt = 1; // 选 x

            for (int y : g[x])

                if (y != fa &&

                   (dis[i][y] < d || dis[i][y] == d && y > j) &&

                   (dis[j][y] < d || dis[j][y] == d && y > i)) // 满足这些条件就可以选

                    cnt *= dfs2(i, j, d, y, x); // 每棵子树互相独立，采用乘法原理

            if (dis[i][x] + dis[j][x] > d)  // x 是可选点

                ++cnt; // 不选 x

            return cnt;

        };

        vector<int> ans(n - 1);

        for (int i = 0; i < n; ++i)

            for (int j = i + 1; j < n; ++j)

                ans[dis[i][j] - 1] += dfs2(i, j, dis[i][j], i, -1);

        return ans;

    }

};

