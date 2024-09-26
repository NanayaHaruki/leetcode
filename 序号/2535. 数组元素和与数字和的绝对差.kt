class Solution {
  fun differenceOfSum(nums: IntArray): Int {
      var sm = 0
      var sn = 0
      for(i in nums.indices){
          var x = nums[i]
          sm+=x
          while(x>0){
              sn+=x%10
              x/=10
          }
      }
      return abs(sm-sn)
  }
}