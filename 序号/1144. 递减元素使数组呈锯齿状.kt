class Solution {
  fun movesToMakeZigzag(nums: IntArray): Int {
    val n = nums.size
    var ops1 = 0
    for (i in 0 until n step 2) {
      val l = nums.getOrNull(i - 1) ?: Int.MAX_VALUE
      val r = nums.getOrNull(i + 1) ?: Int.MAX_VALUE
      val mn = minOf(l, r)
      ops1 += if (nums[i] < mn) 0 else nums[i]-mn+1
    }
    var ops2=0
    for (i in 1 until n step 2){
      val l = nums.getOrNull(i - 1) ?: Int.MAX_VALUE
      val r = nums.getOrNull(i + 1) ?: Int.MAX_VALUE
      val mn = minOf(l, r)
      ops2 += if (nums[i] < mn) 0 else nums[i]-mn+1
    }
    return minOf(ops1,ops2)
  }
}