class Solution {
 public:
  int maxHeight(vector<vector<int>> &cuboids) {
    // 当cube1可以堆叠在cube2上时，l1<=l2 && w1<=w2 && h1<=h2
    // 逆否命题：当l1>l2 || w1>w2 || h1>h2时，cube1无法堆叠在cube2上
    // 对cuboid本身长宽高排序，再对整个集合排序，求LIS

    for (auto &cuboid : cuboids) {
      sort(cuboid.begin(), cuboid.end());
    }
    sort(cuboids.begin(), cuboids.end());
    vector<int> dp(cuboids.size());
    dp[0] = cuboids[0][2];
    int ans = dp[0];
    for (int i = 1; i < cuboids.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (cuboids[j][1] <= cuboids[i][1] &&
            cuboids[j][2] <= cuboids[i][2])  // 0 不用比了，之前排序过了
          dp[i] = max(dp[i], dp[j]);
      }
      dp[i] += cuboids[i][2];
      ans = max(ans, dp[i]);
    }
    return ans;
  }
};