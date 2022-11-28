class Solution {
public:
    /** 分成k个子数组，子数组平均值和的最大值 */
    double largestSumOfAverages(vector<int>& nums, int k) {
      int n = nums.size();
      vector<int> ps(n);
      vector<vector<double>> dp(n,vector<double>(k+1)); // dp[i][j] 包括i索引的数在内，分成j组，平均值最大值
      ps[0]=nums[0];dp[0][1]=ps[0];
      
      // partial_sum(nums.begin(),nums.end(),back_inserter(ps));// basecase 可以在计算前缀和直接赋值，为避免多一轮循环，不用stl
     
      // basecase： j=1，分成1组 根据前缀和直接赋值。

      for(int i=1;i<n;i++){
        ps[i]=ps[i-1]+nums[i];
        dp[i][1]=(double)ps[i]/(i+1);
      }
      // 转移方程： 
      //[0,i]数分成j组，在<=i 有x，前x个数分成j-1组。[x+1,j]分成另一个组，计算[x+1,j]怎么分平均值最大
      // [0,x]分成j-1个组，x+1>=j-1 
      for(int i=0;i<n;i++){
        for(int j=2;j<=k;j++){
          for(int x=j-1;x<=i;x++){ // 此时的x不是上面注释中的x了，而是从x+1 开始的需要计算均值子数组的左端点
            dp[i][j]=fmax(dp[i][j],dp[x-1][j-1]+(double)(ps[i]-ps[x-1])/(i-x+1));
          }
        }
      }
      return dp[n-1][k];
    }
};