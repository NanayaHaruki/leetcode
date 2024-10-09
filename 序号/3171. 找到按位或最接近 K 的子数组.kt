class Solution {
  fun minimumDifference(nums: IntArray, k: Int): Int {
      // logtrick
      var ans = abs(k - nums[0])
      for (i in 1 until nums.size) {
          val x = nums[i]
          ans = min(ans, abs(k - x))
          var j = i-1
          while (j>=0 && nums[j] or x != nums[j]){
              nums[j] = nums[j] or x
              ans = min(ans,abs(k-nums[j]))
              j--
          }
      }
      return ans
  }
}