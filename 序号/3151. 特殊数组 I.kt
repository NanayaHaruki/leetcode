class Solution {
  fun isArraySpecial(nums: IntArray): Boolean {
      var isOdd = (nums[0] and 1) == 1
      for(i in 1 until nums.size){
          val cur = nums[i] and 1 == 1
          if( cur && isOdd) return false
          if(!cur && !isOdd) return false
          isOdd=cur
      }
      return true
  }
}