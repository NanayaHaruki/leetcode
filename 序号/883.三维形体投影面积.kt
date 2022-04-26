fun projectionArea(grid: Array<IntArray>): Int {
  // 求三视图面积总和 长宽高均 n<=50
  // 俯视图面积就是n平方
  // 正视图是在遍历x的时候 取y最大值之和 ；侧视图同理
  val n = grid.size
  var sum1 = 0
  var sum2 = 0
  var sum3 = 0
  for (i in 0 until n) {
    var max1 = 0
    var max2 = 0
    for (j in 0 until n) {
      if (grid[i][j] != 0) sum3++
      max1 = maxOf(max1, grid[i][j])
      max2 = maxOf(max2, grid[j][i])
    }
    sum1 += max1
    sum2 += max2
  }
  return sum1 + sum2 + sum3
}