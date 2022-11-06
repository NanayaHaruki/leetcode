class Solution {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> m;
    int n = nums.size();
    for (int i = 0; i < n; i++) {
      auto ret = m.find(target - nums[i]);
      if (ret == m.end()) {
        m.try_emplace(nums[i],i);
      } else {
        return {i, ret->second};
      }
    }
    return {};
  }
};