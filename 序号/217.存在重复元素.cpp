class Solution {
 public:
  /** 又重复的，返回true */
  bool containsDuplicate(vector<int>& nums) {
    unordered_set<int> set;
    for (auto i : nums) {
      if (!set.emplace(i).second) return true;
    }
    return false;
  }
};