class Solution {
 public:
  bool check(vector<int> &nums) {
    int n = nums.size(),mn = nums[n-1], idx = n-1 ;
    for (int i = n-2; i >=0; i--) {
      if(nums[i]>mn) break;
      if (nums[i] <= mn) {
        mn = nums[i];
        idx = i;
      }
    }
    int pre = mn;
    for (int i = 1; i < n; i++) {
      if (nums[(idx + i) % n] < nums[(idx + i - 1) % n]) return false;
    }
    return true;
  }
};