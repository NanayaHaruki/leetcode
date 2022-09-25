class Solution {
  val errorArr = intArrayOf(3, 4, 7)
  val okArr = intArrayOf(2, 5, 6, 9)
  fun rotatedDigits(n: Int): Int {
    // 必须包含{2，5，6，9}，可以包含{0，1，8}
    // 遍历一边数字，没有3 4 7的同时，2 5 6 9的次数>1
    var j = 0;var mod = 0;var fit = false;var cnt = 0
    for (i in 1..n) {
      j = i
      fit = false
      while (j > 0) {
        mod = j % 10
        if (mod in errorArr) {
          fit = false
          break
        }
        if(mod in okArr)  fit = true
        j/=10
      }
      if (fit) {
        cnt++
      }
    }
    return cnt
  }
}