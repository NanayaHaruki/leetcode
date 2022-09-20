import kotlin.math.pow

class Solution {
  // 22.9.20
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
  
/*
  fun findNthDigit(n: Int): Int {
    // 求1..n 中的第n个数字  11算2个数字  100算3个数字
    // 规律：三位数范围[100,999] 为 10^(3-1),10^3-1
    // 不断累积，算出目标在哪个长度上，得出长度的起始点，因为长度固定了，可以直接算出所求的数
    
    // base case
    var len = 1
    var (start, end) = 1L to 9L
    var k = 9L // len长度的数字上有多少个数
    
    while (k < n) {
      len++
      start *= 10
      end = end * 10 + 9
      k += len * (end - start + 1)
    }
    
    // 找到长度len了，现在要找到哪个数
    // start+len*i = n
    // len长度 总共有 10^len-10^(len-1)个数
    k -= ((10.0.pow(len) - 10.0.pow(len - 1)) * len).toLong()
    val i = (n - k - 1) / len //这个长度的第几个数
    val mod = (n - k - 1).toInt() % len //这个数的第几位
    val ansNum = (10.0.pow(len - 1) + i).toInt()
    return ansNum.toString()[mod] - '0'
  }
  */
 
}