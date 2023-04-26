class Solution {
 public:
  int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
    int n = nums.size();
    vector<int> ps(n + 1);
    int s = 0;
    for (int i = 1; i <= n; i++) {
      ps[i] = ps[i - 1] + nums[i - 1];
    }
    int ans = 0;
    for (int i = firstLen; i <= n; i++) {
      int firstSum = ps[i] - ps[i - firstLen], secondSum = 0;
      for (int j = secondLen; j <= i - firstLen; j++) {
        secondSum = max(secondSum, ps[j] - ps[j - secondLen]);
      }
      for (int j = i + secondLen; j <= n; j++) {
        secondSum = max(secondSum, ps[j] - ps[j - secondLen]);
      }
      ans = max(ans, firstSum + secondSum);
      // cout << i << ',' << ans << endl;
    }
    return ans;
  }
};