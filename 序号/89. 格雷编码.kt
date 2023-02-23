class Solution {
  fun grayCode(n: Int): List<Int> {
      val sz = 1 shl n
      val q = MutableList(sz){0}
      for(i in 0 until sz){
          q[i]=i xor (i shr 1)
      }
      return q
  }
}