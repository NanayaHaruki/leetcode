class Solution {
  lateinit var rowPs: Array<IntArray>
  lateinit var colPs: Array<IntArray>
  fun check(x: Int): Boolean {
    // 用前缀和判断四条边是否都是1
    for (i in x until rowPs.size) {
      for (j in x until rowPs[0].size) {
        if ( rowPs[i-x+1][j] - rowPs[i - x+1][j-x]== x 
          && rowPs[i][j] - rowPs[i][j - x] == x 
          && colPs[i][j] - colPs[i - x][j] == x 
          && colPs[i][j-x+1] - colPs[i-x][j - x+1] == x) {
          return true
        }
      }
    }
    return false
  }

  fun largest1BorderedSquare(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    rowPs = Array(m + 1) { IntArray(n + 1) }
    colPs = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        rowPs[i][j] = rowPs[i][j - 1] + grid[i - 1][j - 1]
        colPs[i][j] = colPs[i - 1][j] + grid[i - 1][j - 1]
      }
    }
    for(x in  kotlin.math.min(m,n) downTo 1){
      if(check(x)) return x*x
    }
    return 0
  }
}