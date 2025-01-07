class Solution {
  fun countKeyChanges(s: String): Int {
      var p = s[0]
      var cnt = 0
      for(c in s){
          if(c==p || (c>='a' && c==p+32) || (c<'a' && c==p-32)) {

          }else{
              cnt++
          }
          p=c
      }
      return cnt
  }
}