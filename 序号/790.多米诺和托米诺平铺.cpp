class Solution {
public:
    /** 2行n列，用——和|_铺满的可能性 */
    int numTilings(int n) {
      // 第i列的可能状态有4种 0.上下都空  1.上满下空 2 上空下满 3 上下都满
      // 0. 上下都空  前项只能是3
      // 1. 上满下空  前项是0和2
      // 2. 上空下满  前项是0和1
      // 3. 上下都满  前项是1.2.3.4 
      vector<vector<int>> dp(n+1,vector<int>(4)); // dp[i][j]表示第i列第j种情况的所有可能数量
      // 第0列是不存在的，不能放东西，状态应该是3，才能让第1列为正常
      dp[0][3]=1;int mod = 1e9+7;
      for(int i = 1;i<=n;++i){
        dp[i][0]=dp[i-1][3];
        dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
        dp[i][2]=(dp[i-1][0]+dp[i-1][1])%mod;
        dp[i][3]=((dp[i-1][0]+dp[i-1][1])%mod+(dp[i-1][2]+dp[i-1][3])%mod)%mod;
      }
      return dp[n][3];
    }
};