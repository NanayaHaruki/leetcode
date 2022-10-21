class Solution {
 public:
  /** 能否分成和相同的两个数组 */
  bool canPartition(vector<int>& nums) {
    int target = 0;
    for (int i : nums) target += i;
    if (target % 2 != 0)
      return false;  // 和不是偶数，自然不能分成相同和的两组数组
    target /= 2;
    // dp[i][j] 表示使用前i个数字，和为j的可能性
    const size_t n = nums.size();

    vector<vector<bool>> dp(n + 1, vector(target + 1, false));
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        if (j < nums[i - 1]) {
          dp[i][j] =
              dp[i - 1][j];  // 总和比当前值还小，放不了，继承少一个数字的结果
        } else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[n][target];
  }
};