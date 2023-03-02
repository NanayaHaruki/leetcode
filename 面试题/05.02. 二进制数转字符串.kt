class Solution {
  fun printBin(num: Double): String {
    // 小数部分转二进制
    var n = num
    var ans = "0."
    for (i in 1..6) {
      n *= 2
      if (n < 1) {
        ans += '0'
      } else {
        ans += '1'
        n -= 1
        if (n == 0.0) return ans
      }
    }
    return "ERROR"
  }
}