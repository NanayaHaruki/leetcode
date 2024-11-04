class Solution {
  val limit = sqrt( Int.MAX_VALUE.toDouble()).toInt()
  val arr  = mutableSetOf<Int>().apply { 
      for (i in 0..limit) add(i*i)
  }

  fun judgeSquareSum(c: Int): Boolean {
      for (i in 0..limit){
          if (arr.contains(c-i*i))return true
      }
      return false
  }
}