class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
      // 全局倒置和局部倒置数量相同，一个数可以比前一个小，但不能比更前的数中的最大值小
      int n = nums.size();
      if(n<2) return true;
      int mx=nums[0];
      for(int i=2;i<n;i++){
        if(nums[i]<mx) return false;
        mx=max(mx,nums[i-1]);
      }
      return true;
    }
};