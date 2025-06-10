class Solution {
  fun maxDifference(s: String): Int {
      // 奇数次最多的 - 偶数次最少的
      var oddCnt = 0
      var evenCnt = 0x3f3f3f3f
      val cnts = IntArray(123)
      for(c in s){
          cnts[c.code]++
      }
      for(i in 'a'.code .. 'z'.code){
          if(cnts[i]==0) continue
          if(cnts[i] % 2 == 1){
              if(cnts[i]>oddCnt){
              oddCnt=cnts[i]
              }
          }else{
              if(cnts[i]<evenCnt){
                  evenCnt = cnts[i]
              }
          }
      }
      return oddCnt - evenCnt
  }
}