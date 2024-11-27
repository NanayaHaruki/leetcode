class Solution {
  fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    val n = colors.size
    // 计算连续区间
    val cache = mutableListOf<IntArray>()
    var l = -1

    for (i in 1 until n) {
      if (colors[i] == colors[i - 1]) {
        if (l == -1) l = i - 1
      } else {
        if (l != -1) {
          cache.add(intArrayOf(l, i - 1))
          l = -1
        }
      }
    }
    if (l != -1) {
      if (colors[0] == colors[n - 1]) {
        if (cache.isEmpty()) {
          cache.add(intArrayOf(l - n, 0))
        } else {
          if (cache[0][0] == 0)
            cache[0][0] = l - n
          else
            cache.add(0, intArrayOf(l - n, 0))
        }
      } else {
        cache.add(intArrayOf(l, n - 1))
      }
    } else {
      if (colors[0] == colors[n - 1]) {
        if (cache.isEmpty())
          cache.add(0, intArrayOf(-1, 0))
        else {
          if (cache[0][0] == 0) {
            cache[0][0] = -1
          } else {
            cache.add(0, intArrayOf(-1, 0))
          }
        }
      }
    }
    if (cache.isEmpty()) return n
    // 根据连续区间，计算合法区间内有m个数，m-k就是可以移动的次数，m-k+1就是合法区间的数量
    var ans = 0
    for (i in 1 until cache.size) {
      val (a, b) = cache[i]
      val (c, d) = cache[i - 1]
      if (a - d + 1 >= k) {
        ans += (a - d - k + 2)
      }
    }
    if (cache[0][0] < 0) {
      ans += max(0, n + cache[0][0] - cache.last()[1] - k + 2)
    } else {
      ans += max(0, cache[0][0] + 1 + n - cache.last()[1] - k + 1)
    }
    return ans
  }
}