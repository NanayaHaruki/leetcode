fun numSpecial(mat: Array<IntArray>): Int {
  // 求特殊位置该店为1 且所在行列只有ta是1
  // 遍历的时候，如果是1，无法判断是否为特殊位置，因为别的点也可以有1。固先预处理出每行和每列总共有几个1，如果只有1且当前点是1，则为特殊位置
  val row = IntArray(mat.size)
  val col = IntArray(mat[0].size)
  for (i in mat.indices){
    for (j in mat[0].indices){
      row[i]+=mat[i][j]
      col[j]+=mat[i][j]
    }
  }
  var ans = 0
  for (i in mat.indices){
    for (j in mat[0].indices){
      if (row[i]==1 && col[j]==1 && mat[i][j]==1){
        ans++
      }
    }
  }
  return ans
}