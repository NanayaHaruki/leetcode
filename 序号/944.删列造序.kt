fun minDeletionSize(strs: Array<String>): Int {
  // abc ； bce ；cae  删除非升序的列，上面第2列需要删除，返回需要删除的列的数量
  val colNum = strs[0].length
  val rowNum = strs.size
  if (rowNum==1)return 0
  var ans = 0
  for (i in 0 until colNum){
    for (j in 1 until rowNum){
      // 比每一列
      if(strs[j][i]-strs[j-1][i]<0){
        ans++
        break
      }
    }
  }
  return ans
}