class Solution {
  fun maxAdjacentDistance(nums: IntArray): Int {
      var ans = abs(nums.last()-nums.first())
      for(i in 1 until nums.size){
          ans = max(ans,abs(nums[i]-nums[i-1]))
      }
      return ans
  }
}