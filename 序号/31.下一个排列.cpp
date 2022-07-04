class Solution {
 public:
  void nextPermutation(vector<int>& nums) {
    // 下一个排列，原地转换
    // 从后向前找到第一个升序i,j,将[j,end]比i大的数中最小的k和i互换。
    // 再将[j,end]倒置。（因为i，j是第一个升序，所以[j,end]是非严格降序，倒置就是升序，得出下一个排序
    int n = nums.size();
    int i, j, k;
    for (i = n - 2; i >= 0; --i) {
      if (nums[i] < nums[i + 1]) {
        // 找到第一个相邻升序
        break;
      }
    }
    if (i == -1) {
        reverse(nums.begin(), nums.end());
        return;
    }
    //，找后面最小排列
    k = i + 1;
    j = k;
    for (; j < n; j++) {
      if (nums[j] > nums[i] && nums[j] <= nums[k]) {
        k = j;
      }
    }
    // 交换ik
    nums[i] = nums[i] ^ nums[k];
    nums[k] = nums[i] ^ nums[k];
    nums[i] = nums[i] ^ nums[k];
    // 翻转i+1后面的
    reverse(nums.begin()+i+1,nums.end());
  }
};