class Solution {
  fun isSubstringPresent(s: String): Boolean {
      val n = s.length
      val d = mutableSetOf<String>()
      for(i in 1 until n){
          if(s[i-1]==s[i]) return true
          val cur = String(charArrayOf(s[i-1],s[i]))
          val rev = String(charArrayOf(s[i],s[i-1]))
          if(d.contains(rev)) return true
          d.add(cur)
      }
      return false
  }
}