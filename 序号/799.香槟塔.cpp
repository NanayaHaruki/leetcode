class Solution {
 public:
  double champagneTower(int poured, int query_row, int query_glass) {
    vector<vector<double>> dp(query_row + 2, vector<double>(query_row + 2));
    dp[0][0] = poured;
    // 第i层有i+1个杯子
    for (int i = 0; i <= query_row; i++) {
      for (int j = 0; j <= i; j++) {
        if (dp[i][j] > 1) {
          double over = (dp[i][j] - 1) / 2 ;
          dp[i + 1][j] += over;
          dp[i + 1][j + 1] += over;
        }
      }
    }
    return min(1.0, dp[query_row][query_glass]);
  }
};