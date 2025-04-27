class Solution {
  fun countSubarrays(nums: IntArray): Int {
      return (2 until nums.size).sumOf {  
          if ((nums[it-2]+nums[it])*2==nums[it-1]) 1.toInt()
          else 0
      }
  }
}