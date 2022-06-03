class Solution {
 public:
  int consecutiveNumbersSum(int n) {
    // 第一个数为a，最后个数为a+k-1，等差数列和为 （a+a+k-1)*k/2=n
    // 可求出k^2<2n,遍历所有k，看a能否满足条件即可
    int ans = 0;
    for (int k = 1; k * k < n * 2; k++) {
      //等差数列公式可知，2a+k-1 为正整数，2n/k = 2a+k-1
      if (2*n % k == 0 && ((2 * n / k + 1 - k) % 2 == 0)) {
        ans++;
      }
    }
    return ans;
  }
};