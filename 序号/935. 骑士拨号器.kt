class Solution {
  val d = arrayOf(
      intArrayOf(4, 6),
      intArrayOf(6, 8),
      intArrayOf(7, 9),
      intArrayOf(4, 8),
      intArrayOf(0, 3, 9),
      intArrayOf(),
      intArrayOf(0, 1, 7),
      intArrayOf(2, 6),
      intArrayOf(1, 3),
      intArrayOf(2, 4)
  )


  companion object {
      val mem = Array(5000) { IntArray(10) }
      val mod = 1_000_000_007
  }

  /** i是剩余移动次数  x是所在位置 */
  fun dfs(i: Int, x: Int): Int {
      if (i == 0) return 1
      if (mem[i][x] > 0) return mem[i][x]
      var ans = 0
      for (next in d[x]) {
          ans = (ans + dfs(i - 1, next)) % mod
      }
      mem[i][x] = ans
      return ans
  }

  fun knightDialer(n: Int): Int {
      if (n == 1) return 10
      var ans = 0
      for (x in 0..9) {
          ans = (ans + dfs(n - 1, x)) % mod
      }
      return ans
  }
}