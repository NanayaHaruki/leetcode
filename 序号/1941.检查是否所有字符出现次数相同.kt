class Solution {
  fun areOccurrencesEqual(s: String): Boolean {
    val arr = IntArray(26)
    for(c in s) arr[c-'a']++
    var ans = true
    var preCnt = 0
    for(cnt in arr){
      if(cnt!=0) {
        if(preCnt==0){
          preCnt=cnt
        }else{
          if(cnt!=preCnt){
            ans=false
            break
          }
        }
        
      }
    }
    return ans
  }
}