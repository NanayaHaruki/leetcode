class Solution {
  fun waysToSplitArray(nums: IntArray): Int {
      var total = 0L
      nums.forEach { total+=it }
      var sm = 0L
      var ans = 0
      for(i in 0 .. nums.size-2){
          sm+=nums[i]
          if(sm>=total-sm){
              ++ans
          }
      }
      return ans
  }
}