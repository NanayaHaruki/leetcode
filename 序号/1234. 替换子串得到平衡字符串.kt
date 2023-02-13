class Solution {
  lateinit var Q: IntArray
  lateinit var W: IntArray
  lateinit var E: IntArray
  lateinit var R: IntArray
  fun check(s: String, mid: Int): Boolean {
    val n = s.length
    val cnts = IntArray(4)
    out@ for (i in mid..s.length) {
      // 计算取出中间的子串，其他的字符还剩多少个
      cnts[0] = Q[i - mid] + Q[n] - Q[i]
      cnts[1] = W[i - mid] + W[n] - W[i]
      cnts[2] = E[i - mid] + E[n] - E[i]
      cnts[3] = R[i - mid] + R[n] - R[i]
      var sum = 0
      for (cnt in cnts) {
        sum += cnt
        if (cnt > n / 4) continue@out
      }
      if (sum + mid == n) return true
    }
    return false
  }

  fun balancedString(s: String): Int {
    // 替换子串使 QWER 出现次数相同。
    // 前缀和求出QWER区间长度。替换掉3/4长度肯定能成功，最小就是不用替换
    val n = s.length
    Q = IntArray(n + 1)
    W = IntArray(n + 1)
    E = IntArray(n + 1)
    R = IntArray(n + 1)
    for (i in 1..n) {
      Q[i] = Q[i - 1]
      W[i] = W[i - 1]
      E[i] = E[i - 1]
      R[i] = R[i - 1]
      when (s[i - 1]) {
        'Q' -> Q[i]++
        'W' -> W[i]++
        'E' -> E[i]++
        else -> R[i]++
      }
    }
    if (Q[n] == n / 4 && W[n] == n / 4 && E[n] == n / 4 && R[n] == n / 4) return 0 // 平分了，不用操作
    var l = 0;
    var r = n / 4 * 3 + 1 // 开区间二分
    while (l + 1 < r) {
      val mid = (l + r) / 2
      if (check(s, mid)) {
        r = mid
      } else {
        l = mid
      }
    }
    return r
  }
}