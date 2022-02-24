class Solution {
  lateinit var ans: IntArray
  lateinit var grid: Array<IntArray>
  var maxRow = 0
  var maxCol = 0
  fun findBall(_grid: Array<IntArray>): IntArray {
    // 0球从 1格掉出，则ans[0]=1,卡住了为-1
    grid = _grid
    maxRow = grid.size - 1
    maxCol = grid[0].size - 1
    ans = IntArray(maxCol + 1)
    for (i in 0..maxCol) {
      dfs(0, i, i)
    }
//    dfs(0,0,0)
    return ans
  }
  
  fun dfs(row: Int, col: Int, oriCol: Int) {
    println("$row $col $oriCol")
    if (row == maxRow + 1) { //已经掉出来了
      ans[oriCol] = col
      return
    }
    if (grid[row][col] == 1) {// 球向右
      if (col == maxCol) { // 右边界 卡住了
        ans[oriCol] = -1
        return
      } else {
        if (grid[row][col + 1] == 1) { // 通行到下一行
          dfs(row + 1, col + 1, oriCol)
        } else {
          ans[oriCol] = -1 // 卡住了
          return
        }
      }
    } else { // 球向左
      if (col == 0) { // 左边界 卡住了
        ans[oriCol] = -1
        return
      } else {
        if (grid[row][col - 1] == 1) { // 左边是向右的，卡住了
          ans[oriCol] = -1
          return
        } else {
          dfs(row + 1, col - 1, oriCol)
        }
      }
    }
  }
}