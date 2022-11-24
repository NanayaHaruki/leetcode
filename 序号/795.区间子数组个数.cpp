class Solution {
 public:
  int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
    // 找出大于right的数，在这些数之间计算连续子数组个数
    // 遍历每个数，满足[left,right],更新最大值，记录第一个满足条件的索引；不满足条件索引设置-1
    // 包含当前数的子数组个数为 len
    int ans = 0, l = -1, r = -1, len,
        n = nums.size();  // l为大于区间的 r为处于区间的
    for (int i = 0; i < n; i++) {
      if (nums[i] > right) {  // 大于区间，什么都不做
        l = i;r=-1;
      } else if (nums[i] < left) {
        if (r!=-1) ans+= r-l;     
      } else {
        r=i;
        ans+=r-l;
      }
    }
    return ans;
  }
};