class Solution {
  private fun check(nums: IntArray, mx: Int, p: Int): Boolean {
      var cnt = 0
      var i = 1
      while (i < nums.size) {
          if (nums[i] - nums[i - 1] <= mx) {// mid作为最大的差值，判断小于这个最大值的数对有没有p对
              ++cnt
              i += 2
          } else {
              i += 1
          }
      }

      return cnt >= p
  }

  fun minimizeMax(nums: IntArray, p: Int): Int {
      // 最大最小用二分
      // 找出p对，p对中差值最大的一对的值最小
      // 二分答案，检查能否满足p
      if (p == 0) return 0
      nums.sort()
      var l = -1
      var r = nums.max() - nums.min() +1
      while (l + 1 < r) {
          val mid = (l + r) / 2
          if (check(nums, mid, p)) {
              r=mid
          }else{
              l=mid
          }
      }
      return r
  }
}