fun setZeroes(matrix: Array<IntArray>): Unit {
  val m = matrix.size
  val n = matrix[0].size
  val clearRows = mutableSetOf<Int>()
  val clearCols = mutableSetOf<Int>()
  for (i in 0 until m){
    for (j in 0 until n){
      if (matrix[i][j]==0){
        clearRows.add(i)
        clearCols.add(j)
      }
    }
  }
  for (row in clearRows){
    for (i in 0 until n){
      matrix[row][i]=0
    }
  }
  for (col in clearCols) {
    for (i in 0 until m) {
      matrix[i][col] = 0
    }
  }
}