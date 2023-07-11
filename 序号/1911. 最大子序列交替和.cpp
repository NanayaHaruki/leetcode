class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        size_t n = nums.size();
        vector<vector<long long>>dp(n,vector<long long>(2,0)); // dp[i][0] [0,i]的子序列，i为奇数的最大和  dp[i][1]为偶数
        dp[0][0]=nums[0];
        for(size_t i =1;i<n;i++){
            dp[i][0]=max(dp[i-1][1]+nums[i],dp[i-1][0]); // 偶数最大和为上一个奇数+自己 或 上一个偶数保持不变
            dp[i][1]=max(dp[i-1][0]-nums[i],dp[i-1][1]);
        }
        return max(dp[n-1][0],dp[n-1][1]);
    }
};