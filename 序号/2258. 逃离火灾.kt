class Solution {
  val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
  fun maximumMinutes(grid: Array<IntArray>): Int {
    // 0草 1\U0001f525 2\U0001f9f1，返回停留最长时间后还能抵达右下角。到不了返回-1，停多久都能到，返回1e9
    val m = grid.size
    val n = grid[0].size
    fun bfs(q: ArrayDeque<IntArray>): IntArray {
      val time = Array(m) { IntArray(n) { -1 } }
      var t = 0
      while (q.isNotEmpty()) {
        val sz = q.size
        for (i in 0 until sz) {
          val (x, y) = q.removeFirst()
          time[x][y] = t
          for (dir in dirs) {
            val newX = x+dir[0]
            val newY = y+dir[1]
            if (newX in 0 until m && newY in 0 until n && grid[newX][newY] == 0 && time[newX][newY] == -1) {
              q.add(intArrayOf(newX, newY))
            }
          }

        }
        t++
      }
      return intArrayOf(time[m - 1][n - 1], time[m - 2][n - 1], time[m - 1][n - 2])
    }
    // 统计火和人到达每个点的最快时间，人更快到房间即可。不会出现火截断人通路的情况，因为火如果截断了，火必定比人更早到房间
    val (a1, b1, c1) = bfs(ArrayDeque<IntArray>().apply { add(intArrayOf(0, 0)) })
    val burns = ArrayDeque<IntArray>()
    for (x in 0 until m) {
      for (y in 0 until n) {
        if (grid[x][y] == 1) {
          burns.add(intArrayOf(x, y))
        }
      }
    }
    val (a2, b2, c2) = bfs(burns)
    if (a1 == -1) return -1 // 人到不了终点
    if (a2 == -1) return 1000000000 // 火到不了终点
    val ans = a2 - a1 // 火比人晚到的时间，就是人可以等待的最大时间
    if (ans < 0) return -1 // 人到终点的时间更长
    if (b1 == -1 || c1 == -1 || 
      (b2 - b1 == ans && c2 - c1 == ans) // 只有 与运算才能保证 人火一路
    ) {
      // 一条路封住了，或者 最后一格重合了
      return ans - 1
    }
    return ans
  }
}