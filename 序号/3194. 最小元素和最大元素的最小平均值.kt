class Solution {
  fun minimumAverage(nums: IntArray): Double {
      nums.sort()
      val n = nums.size
      var ans = Double.MAX_VALUE
      for(i in 0 until n/2){
          ans = min(ans,(nums[i]+nums[n-i-1])/2.0)
      }
      return ans
  }
}