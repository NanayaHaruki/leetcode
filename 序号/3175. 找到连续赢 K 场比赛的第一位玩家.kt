class Solution {
  fun findWinningPlayer(skills: IntArray, k: Int): Int {
      val n = skills.size
      var l = 0
      var r=1
      var winCnt = 0
      while(r<n){
          if(skills[l]>skills[r]) {
              r++
              winCnt++
          }else{
              l=r++
              winCnt=1
          }
          if(winCnt==k) return l
      }
      return l
  }
}