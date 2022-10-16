class Solution {
  /**
   * n个人，dislikes表示两两不喜欢，返回能否分成2组
   * */
  private lateinit var data :IntArray
  private fun find(i:Int):Int{
    if (data[i]!=i) data[i]=find(data[i])
    return data[i]
  }
  
  private fun union(a:Int,b:Int){
    val parentA = find(a);val parentB = find(b)
    if (parentA==parentB) return
    data[parentA]=parentB
  }
  fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
    // 因为dislikes[i] 长度为2，所以要先统计出每个人不喜欢的所有人。
    // 每个人不喜欢的那一堆必然分在一组里。用并查集连接起来，当发现无法连接
    data = IntArray(n+1){it}
    val unlike = List<MutableList<Int>>(n+1){ mutableListOf()}
    for ((a,b) in dislikes){
      unlike[a].add(b)
      unlike[b].add(a)
    }
    // 连接
    for (i in 1 .. n){
      // 将讨厌的人连在一起
      val unlikeList = unlike[i]
      if (unlikeList.isEmpty()) continue
      for (k in 1 until unlikeList.size){
        union(unlikeList[k],unlikeList[k-1])
      }
      // 判断一下自己和讨厌的那组有没有重合
      if (find(i)==find(unlikeList[0])) return false
    }
    return true
  }
}