class Solution {
  fun kthCharacter(k: Long, operations: IntArray): Char {
      val m = 63-(k-1).countLeadingZeroBits()
      var cnt = 0
      for (i in m downTo 0){
          if((k-1).shr(i).and(1)==1L && operations[i]==1) {
              cnt+=operations[i]
          }
      }
      return 'a'+cnt%26
  }
}