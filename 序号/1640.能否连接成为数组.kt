/** pieces 能否链接成arr */
fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
  // pieces元素各不相同，遍历一边，拿到每个IntArray的第一个元素，放进map做key，索引做value，一个个对应arr
  val d = mutableMapOf<Int,Int>()
  for (i in pieces.indices){
    val first = pieces[i][0]
    d[first]=i
  }
  var i = 0
  while (i<arr.size){
    val idxOfPieces = d[arr[i]]?:return false // arr的元素在pieces中不存在
    val arrOfPieces = pieces[idxOfPieces]
    for (j in arrOfPieces){
      if (arr[i]!=j) return false // pieces中元素顺序和arr中不同
      i++
    }
  }
  return true
}