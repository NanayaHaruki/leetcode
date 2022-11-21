class Solution {
public:
    double soupServings(int n) {
      n = (n+24)/25;
      if(n>=179) return 1;
      vector<vector<double>> dp(n+1,vector<double>(n+1));
      // base case  dp[i][j]表示a还有i，b还有j时候的概率
      // i=j=0，A先完概率为0，同时完概率为1,  所求为0+1/2=0.5
      dp[0][0]=0.5;

      // i>0,j=0,A先完概率为0，同时完概率为0，所求为0
      // 默认就是0，不用管

      // i=0,j>0,A先完概率为1，同时完概率为0，所求为1
      for(int j = 1;j<=n;j++){
        dp[0][j]=0.5;
      }

      for(int i = 1;i<=n;i++){
        for(int j=1;j<=n;j++){
          dp[i][j]=0.25*(dp[max(0,i-4)][j]+dp[max(0,i-3)][j-1]+dp[max(0,i-2)][max(0,j-2)]+dp[i-1][max(0,j-3)]);
        }
      }
      return dp[n][n];
    }
};