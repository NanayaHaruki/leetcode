class Solution {
  /** 交换字符的最小次数，使字符串相等 */
  val d = mutableMapOf<String,Int>()
  lateinit var s :CharArray
  lateinit var t:CharArray
  var n = 0
  fun kSimilarity(s1: String, s2: String): Int {
    s=s1.toCharArray()
    t =s2.toCharArray()
    n=s.size
    var minCnt = 0
    
    return dfs(0)
  }
  
  fun dfs(index:Int):Int{
    val preCnt = d[String(s,index,n-index)]
    if (preCnt!=null) return preCnt
    var indexS = -1;var indexT = -1
    for (i in index until n){
      val tmp = t[i]
      if (s[i]==tmp) continue
      indexS=i
      break
    }
    if (indexS==-1) {
      d[String(s,index,n-index)]=0
      return 0
    }
    var min = Int.MAX_VALUE
    for (i in indexS+1 until n){
      if (s[i]==t[indexS]){
        indexT=i
        val target = s[indexT]
        s[indexT]=s[indexS]
        s[indexS]=target
        val cnt = dfs(indexS+1)
        min= minOf(min,cnt)
        s[indexS]=s[indexT]
        s[indexT]=target
      }
    }
    d[String(s,index,n-index)]=min+1
    return min+1
  }
}