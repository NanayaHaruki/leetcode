class Solution {
  fun countNumbersWithUniqueDigits(n: Int): Int {
    // 10^n内有多少个每位数字都不重复的
    // 第一位不能为0，有9种选择；第2位除了0 ，还有8种，加上0，也有9种，第3位8种，第4位7种。。。
    if (n==0) return 1
    var ans = 10
    var cnt = 9 // 第一位是9种选择
    for (i in 2..n){
      cnt*=(11-i) // 第2位是9种 第3位是8种 用11-i即可
      ans+=cnt
    }
    return ans
  }
}