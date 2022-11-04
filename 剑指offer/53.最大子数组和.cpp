class Solution {
 public:
    int maxSubArray(vector<int>& nums) {
      size_t len=nums.size();
      int ans=0,pre=nums[0];
      for(size_t i=1;i<len;i++){
        int cur = nums[i];
        pre=max(cur,pre+cur);
        ans=max(ans,pre);
      }
      return ans;
    }
};