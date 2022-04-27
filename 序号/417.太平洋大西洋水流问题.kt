class Solution() {
  lateinit var heights: Array<IntArray>
  fun pacificAtlantic(_heights: Array<IntArray>): List<List<Int>> {
    // heights是高度，返回可以雨水可以同时流向左/上 和 右/下的点
    // 沿岸的都可以，从边界往中间推即可
    heights = _heights
    
    // 左上往右下推
    val m1 = Array(heights.size) { IntArray(heights[0].size) }
    val m2 = Array(heights.size) { IntArray(heights[0].size) }
    for (y in heights.indices) {
      dfs(0, y, m1)
      dfs(heights[0].lastIndex, y, m2)
    }
    for (x in heights[0].indices) {
      dfs(x, 0, m1)
      dfs(x, heights.lastIndex, m2)
    }
    
    
    val ans = mutableListOf<List<Int>>()
    for (y in m1.indices) {
      for (x in m1[0].indices) {
        if (m1[y][x] == 1 && m2[y][x] == 1) ans.add(listOf(y, x))
      }
    }
    return ans
  }
  
  val direction = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0))
  fun dfs(x: Int, y: Int, memory: Array<IntArray>) {
    if (memory[y][x] != 0) return // 之前走过这里，返回
    memory[y][x] = 1
    for ((diffX, diffY) in direction) {
      val xi = x + diffX
      val yi = y + diffY
      if (xi in 0 until heights[0].size && yi in 0 until heights.size && heights[y][x] <= heights[yi][xi]) {
        dfs(xi, yi, memory)
      }
    }
  }
}