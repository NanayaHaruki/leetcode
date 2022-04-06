class Solution {
  fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    // 找最小深度的根
    // 用map记录每个数字相连的有哪些
    // 用list记录每个数字的度
    // 不断找度为1的数，剪枝最后留下的就是根
    val ans = mutableListOf<Int>()
    if (n == 1) {
      ans.add(0)
      return ans
    }
    val dict = mutableMapOf<Int, MutableSet<Int>>()
    val degrees = Array(n) { 0 }
    for ((a, b) in edges) {
      degrees[a]++
      degrees[b]++
      var set = dict.getOrDefault(a, mutableSetOf())
      set.add(b)
      dict[a] = set
      set = dict.getOrDefault(b, mutableSetOf())
      set.add(a)
      dict[b] = set
    }
    val queue = ArrayDeque<Int>()
    for (i in 0 until n) {
      if (degrees[i] == 1) queue.add(i)
    }
    while (queue.isNotEmpty()) {
      // ans存储的是上次循环中 度为1的数所连接的数
      // 如果跳出循环了，那么ans就是可以为根的数。
      // 如果还有其他度为1的数，需要继续找，那么要将ans清空
      ans.clear()
      // 计算每一层有多少个，从队列中弹几个出来
      val size = queue.size
      // 找出相连的
      for (i in 0 until size) {
        val j = queue.poll()
        ans.add(j)
        val set = dict.getOrDefault(j, mutableSetOf())
        // 将set中的数的深度-1，检查如果有度为1的，再加入队列进入下次循环
        for (k in set) {
          degrees[k]--
          if (degrees[k] == 1) queue.add(k)
        }
        
      }
    }
    return ans
  }
}