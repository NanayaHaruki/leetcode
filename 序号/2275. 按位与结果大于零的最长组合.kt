class Solution {
  fun largestCombination(candidates: IntArray): Int {
      val cnts = IntArray(32)
      for (i in 0 until 31){
          val f = 1 shl i
          for (x in candidates){
              if(x.and(f)==f){
                  cnts[i]++
              }
          }
      }
      return cnts.max()
  }
}