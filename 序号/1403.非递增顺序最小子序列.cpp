class Solution {
public:
  vector<int> minSubsequence(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    vector<int> v;
    int sum = 0;
    for (const int i : nums) sum += i;
    int curSum = 0;
    for (int i = nums.size() - 1; i >= 0; i--) {
      curSum += nums[i];
      v.push_back(nums[i]);
      if (curSum > sum / 2) break;
    }
    return v;
  }
};