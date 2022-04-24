fun binaryGap(n: Int): Int {
  // 二进制2个1的最长距离
  var f = 1
  var pre = -1
  var ans = 0
  for (i in 0..31) {
    if (n and f == f) {
      if (pre == -1) {
        pre = i
      } else {
        ans = maxOf(ans, i - pre)
        pre = i
      }
    }
    f = f shl 1
  }
  return ans
}