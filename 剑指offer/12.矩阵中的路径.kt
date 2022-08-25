class Solution {
  lateinit var board: Array<CharArray>
  lateinit var word: CharArray
  fun exist(_board: Array<CharArray>, _word: String): Boolean {
    board = _board;word = _word.toCharArray()
    // 找出指定单词
    // 找到首字母
    for (i in board.indices) {
      for (j in board[0].indices) {
        board[i][j]=board[i][j]-65 //回溯套路-选择
        if (dfs(i, j, 0)) return true// 干活
        board[i][j]=board[i][j]+65 //取消选择
      }
    }
    return false
  }

  val d = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

  /** 当前在board[row][col],需要在上下左右临格找word[i+1]
   * 走过的格子-65  A变成0 z变成122-65 ，走过的格子全部<65 */
  fun dfs(row: Int, col: Int, i: Int): Boolean {
    if (board[row][col] != word[i]-65) // 干活是回溯第2步，第一步做选择的时候，已经-65了，这里记得判断
      return false
    if(i==word.size-1) // 上一行没返回，说明字符是相等的，又是最后一个字符了，回溯结束，找到啦
      return true

    for ((dx, dy) in d) {
      val newRow = row + dx
      val newCol = col + dy
      // 越界的和走过的格子直接跳过
      if(newRow<0||newCol<0||newRow>=board.size||newCol>=board[0].size||board[newRow][newCol].toInt()<65)
        continue
      board[newRow][newCol] =board[newRow][newCol]-65 //回溯步骤1 -选择
      val ret = dfs(newRow, newCol, i + 1) // 步骤2 - 干活
      if (ret) {
        return true
      }
      board[newRow][newCol]=board[newRow][newCol]+65 // 步骤3 取消选择
    }
    return false
  }
}
