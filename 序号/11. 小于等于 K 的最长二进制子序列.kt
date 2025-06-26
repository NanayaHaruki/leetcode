class Solution {
  fun longestSubsequence(s: String, k: Int): Int {
      // 从右往左，有0拿0,有1不超过k也拿
      val n = s.length
      var cnt = 0
      var curNum = 0
      for(i in n-1 downTo 0){
          if(s[i]=='0') cnt++
          else {
              if(n-1-i>=31) continue
              val tmp = curNum.or(1.shl(n-1-i))
              if(tmp<=k){
                  curNum = tmp
                  cnt++
              }
          }
      }
      return cnt
  }
}