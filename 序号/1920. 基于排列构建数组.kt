class Solution {
  fun buildArray(nums: IntArray): IntArray {
      return IntArray(nums.size).apply{
          for(i in nums.indices)
              this[i]=nums[nums[i]]
      }
  }
}