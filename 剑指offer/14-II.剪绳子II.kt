class Solution {
  fun cuttingRope(n: Int): Int {
    // n>=2, n=2,不剪积最大。
    // n=3，不剪为3，剪1和2，积为2，剪1 1 1，积为1
    // n=4 不剪为4  剪2和2，随意
    // n=5，不剪为5 剪2和3 积为6
    // n=6，剪3和3 最大
    // n>=7,都可以拆成1-6的，4剪不剪一样，>4都是拆了更大。题目转化成n可以拆成多少个3，尽量拆出更多的3.但是余1的时候，不能拆3，因为3*1<2*2
    
    // 题目要求n必须要剪
    if (n == 2) return 1
    if (n == 3) return 2
    val a = n / 3;
    val b = n % 3;
    val mod = 1000000007
    // 注意，这里不能用 3.pow(x) 来求，会超出double的15位有效数字，可以用快速幂用logN求出幂
    return when (b) {
      1 -> (fastPow(3, a - 1, mod) * 4 % mod).toInt()
      2 -> (fastPow(3, a, mod) * 2 % mod).toInt()
      else -> fastPow(3, a, mod).toInt()
    }
  }
  
  fun fastPow(base: Int, pow: Int, mod: Int): Long {
    var b = base.toLong();
    var p = pow
    var ans = 1L
    while (p > 0) {
      if (p%2==1)
        ans = ans * b % mod
      b = b * b % mod
      p /= 2
    }
    return ans
  }
  
}