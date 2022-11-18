class Solution {
  const static int mod = 1e9 + 7;

 public:
  int sumSubseqWidths(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    int n = nums.size();
    vector<int> pow2(n);
    pow2[0]=1;
    for(int i = 1;i<n;i++){
      pow2[i]= pow2[i-1]*2%mod;
    }
    long ans = 0;
    for (int i = 0; i < n ; i++) {
       // 每个数能当最大值的次数 2^i; 能当最小值的次数是2*(n-1-i);
       // 因为 i为1e5，越界，提前处理好模
       int k = (pow2[i]-pow2[n-1-i])*1ll*nums[i]%mod;
       ans = (ans+k)%mod;
    }
    return ans;
  }
};