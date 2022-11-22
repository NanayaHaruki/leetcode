class Solution {
 private:
  int mod = 1e9 + 7;
  int gcd(int a,int b){
    return b?gcd(b,a%b):a;
  }
  int lcm(int a,int b){
    return a/gcd(a,b)*b;
  }
 public:
  /**第n个能被a或b整除的数*/
  int nthMagicalNumber(int n, int a, int b) {
    long long ans = 0, l = 0, r = 1ll*n * min(a, b), m;
    int _lcm = lcm(a,b);
    while (l <= r) {
      m = l + (r - l) / 2;
      // 检查m以内有多少个神奇数
      int cnt = m/a+m/b-m/_lcm;
      if(cnt>n) r=m-1;
      else if(cnt<n) l=m+1;
      else r=m-1;
    } 
    return int(l%mod);
  }
};