class Solution {
  fun check(len:Int,s:String):Boolean{
    val cnts = IntArray(26)
    var tmp =IntArray(26)
    s.forEachIndexed { index, c ->
      // 每段长len，统计字符数量。
      if (index/len==0){
        cnts[c-'a']++
      }else{
        if (index%len==0){
          tmp = IntArray(26)
        }
        tmp[c-'a']++
        if(index%len == len-1){
          if (!cnts.contentEquals(tmp)) return false
        }
      }
    }
    return true
  }
  fun minAnagramLength(s: String): Int {
    val n = s.length
    for(i in 1..n/2){
      if (n%i!=0) continue
      if (check(i,s)) return i
    }
    return n
  }
}