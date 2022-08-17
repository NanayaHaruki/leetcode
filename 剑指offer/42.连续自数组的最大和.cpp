class Solution {
 public:
  int maxSubArray(vector<int>& nums) {
    // 子序列和最大
    int len = nums.size();
    vector<int> dp(len); // dp[i]表示末尾是i的子序列最大值
    dp[0]=nums[0];
    int ans = dp[0];
    for(int i = 1;i<len;i++){
      if(dp[i-1]>0) dp[i]=dp[i-1]+nums[i];
      else dp[i]=nums[i];
      ans=max(ans,dp[i]);
    }
    return ans;
  }
};