class Solution {
  fun minimumOperations(nums: IntArray): Int {
    val s = mutableSetOf<Int>()
    for(i in nums) {
      if (i>0) s.add(i)
    }
    return s.size
  }
}