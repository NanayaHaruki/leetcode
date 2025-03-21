class Solution {
  fun maximumOr(nums: IntArray, k: Int): Long {
      var allOr = 0
      var fix = 0
      nums.forEach{x->
          fix = fix or (allOr and x)
          allOr = allOr or x
      }
      return nums.map { (allOr xor it or fix).toLong() or it.toLong().shl(k) }.max()
  }
}