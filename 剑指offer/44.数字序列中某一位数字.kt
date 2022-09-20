class Solution {
  val len = intArrayOf(0, 9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889)
  fun findNthDigit(n: Int): Int {
    var l = 0
    for (i in len.indices) {
      if (n <= len[i]) {
        l = i
        break
      }
    }
    if (l == 0) l = 9
    // 计算少一位的数字长度
    val preLen = len[l - 1]
    val curLen = n - preLen - 1
    val preNums = curLen / l // 当前位数，前面有多少个数字
    val bitOfNum = curLen % l // 所求在这个数字的第几位上
    var min = 1
    for (i in 0 until l - 1) min *= 10
    val cur = min + preNums
    return cur.toString()[bitOfNum] - '0'
  }
  
  fun len(n: Int): Long {
    var min = 1L
    var max = 9L
    for (j in 0 until n - 1) {
      max = (max * 10 + 9)
      min *= 10
    }
    
    return n * (max - min + 1)
  }
}