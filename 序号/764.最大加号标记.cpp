class Solution {
 public:
  int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
    vector<vector<int>> table(n + 1, vector<int>(n + 1,1)),
        a(n + 1, vector<int>(n + 10)), b(n + 1, vector<int>(n + 10)),
        c(n + 1, vector<int>(n + 10)), d(n + 1, vector<int>(n + 10));
    for (auto& p : mines) {
      table[p[0] + 1][p[1] + 1] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (table[i][j] == 1) {
          a[i][j] = a[i - 1][j] + 1;
          b[i][j] = b[i][j - 1] + 1;
        }
        if (table[n + 1 - i][n + 1 - j] == 1) {
          c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
          d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
        }
      }
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        ans = max(ans, min({a[i][j], b[i][j], c[i][j], d[i][j]}));
      }
    }
    return ans;
  }
};