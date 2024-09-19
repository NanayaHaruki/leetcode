class Solution {
  fun longestContinuousSubstring(s: String): Int {
      var c = s[0]
      var len = 1
      var ans = 0
      for(i in 1 until s.length){
          if(s[i]-c==1){
              ++len
          }else{
              ans=max(ans,len)
              len=1
          }
          c=s[i]
      }
      return max(ans,len)
  }
}