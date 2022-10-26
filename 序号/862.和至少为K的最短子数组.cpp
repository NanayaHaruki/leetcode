class Solution {
 public:
  /** 连续子数组中和大于等于k的最小长度 */
  int shortestSubarray(vector<int>& nums, int k) {
    // 先算前缀和，再从前缀和中判断每个以i位置结束的子数组中不小于k的长度
    vector<long long> preSum(nums.size() + 1, 0);
    for (int i = 1; i <= nums.size(); i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
    // 如果前缀和找到了满足的[j,i],后面遍历不必考虑j起点的了，因为都会比这个长
    // 如果preSum[i]<preSum[j]小，后面遍历不必考虑j起点的了，因为如果有满足的k为右端点，那[i,k]一定也满足，且比[j,k]更短
    deque<int> l{0};  // 存储左端点
    int ans = -1;
    for (int i = 1; i < preSum.size(); i++) {
      while (!l.empty() && preSum[i] - preSum[l.front()] >= k) {
        if (ans == -1)
          ans = i - l.front();
        else
          ans = min(ans, i - l.front());
        l.pop_front();
      }
      while (!l.empty() && preSum[i] < preSum[l.back()]) {
        l.pop_back();
      }
      l.emplace_back(i);
    }
    return ans;
  }
};