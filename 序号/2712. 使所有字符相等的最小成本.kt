class Solution {
  fun minimumCost(s: String): Long {
      val n = s.length
      val prefix = LongArray(n)
      val suffix = LongArray(n)
      for(i in 1 until n){
          prefix[i] = prefix[i-1] + if (s[i-1]==s[i]) 0 else i // 将i-1变成和i一样，成本为i
          
      }
      for(i in n-2 downTo 0){
          suffix[i]=suffix[i+1]+ if(s[i+1]==s[i]) 0 else n-i-1
      }
      return prefix.zip(suffix).minOf { it.first+it.second }
  }
}