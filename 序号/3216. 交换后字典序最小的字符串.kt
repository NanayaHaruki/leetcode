class Solution {
  fun getSmallestString(s: String): String {
      val cs = s.toCharArray()
      for(i in 1 until cs.size){
          val a = cs[i-1]-'0'
          val b = cs[i]-'0'
          if( a.and(1) == b.and(1) && a>b){
              cs[i-1]='0'+b
              cs[i]='0'+a
              break
          }

      }
      return String(cs)
  }
}