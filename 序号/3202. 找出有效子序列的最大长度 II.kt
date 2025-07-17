class Solution {
  fun maximumLength(nums: IntArray, k: Int): Int {
      // 找最长子序列的长度，要求相邻两元素的之和模k相等。
      // 模k相等，有[0,k-1]种情况，定义f[i][j] 和的模为i，上一个数为j的最大长度
      val f = Array(k) { IntArray(k) }
      for (x in nums) {
          val mod = x % k
          // println("cur = $x ,mod=$mod")
          for (i in 0 until k) {
              val j = (i - mod + k) % k
              if (f[i][j] == 0) continue
              f[i][mod] = f[i][j] + 1

          }
          for(i in 0 until k) {
              if (f[i][mod]==0) f[i][mod]=1
//                println("    f[$i][$mod]=${f[i][mod]}")
          }
      }
      return f.maxOf { it.max() }
  }
}