fun construct(grid: Array<IntArray>): Node? {
  fun dfs(r0: Int, r1: Int, c0: Int, c1: Int): Node {
    val a = grid[r0][c0]
    var same = true
    a@ for (i in r0 until r1) {
      for (j in c0 until c1) {
        if (grid[i][j] != a) {
          same = false
          break@a
        }
      }
    }
    return if (same) Node(a == 1, true)
    else Node(`val` = true, isLeaf = false).apply {
      topLeft = dfs(r0, (r0 + r1) / 2, c0, (c0 + c1) / 2)
      topRight = dfs(r0, (r0 + r1) / 2, (c0 + c1) / 2, c1)
      bottomLeft = dfs((r0 + r1) / 2, r1, c0, (c0 + c1) / 2)
      bottomRight = dfs((r0 + r1) / 2, r1, (c0 + c1) / 2, c1)
    }
  }
  return dfs(0, grid.size, 0, grid[0].size)
}