import kotlin.math.abs

class Solution {
  fun minMoves2(nums: IntArray): Int {
    // 返回所有元素相等的最少移动数
    // 所有数都变成中位数最小
    nums.sort()
    val m = nums[nums.size/2]
    var ans = 0
    for (num in nums) ans+= abs(num-m)
    return ans
  }
}