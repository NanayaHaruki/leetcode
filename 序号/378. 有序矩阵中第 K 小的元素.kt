class Solution {
  fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
      // 找矩阵中第k小的数，二分枚举一个数，检查矩阵中不大于这个数的有多少个，
      // 检查过程中继续2分，计算每行有多少个
      val n = matrix.size
      fun calc(x: Int): Int {
          var ans = 0
          for (i in 0 until n) {
              if (matrix[i][0] > x) break
              var l = -1
              var r = n
              while (l + 1 < r) {
                  val m = (l + r) / 2
                  if (matrix[i][m] <= x) l = m
                  else r = m
              }
              ans += r
          }
          return ans
      }

      var l = -1_000_000_001
      var r = 1_000_000_001
      while (l + 1 < r) {
          val m = (l + r) / 2
          if (calc(m) < k) l = m
          else r = m
      }
      return r
  }
}