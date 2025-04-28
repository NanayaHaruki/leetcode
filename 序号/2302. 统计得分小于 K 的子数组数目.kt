class Solution {
  fun countSubarrays(nums: IntArray, k: Long): Long {
      // 枚举右，维护左，每次达到最长距离[l,r]时，包括r的子数组有r-l+1个
      // 当r不能往右移（会超出k的限制时，右移左端点）
      var l = 0
      var sum = 0L
      return nums.indices.sumOf{r -> 
          sum+=nums[r]
          while(sum*(r-l+1)>=k){
              sum-=nums[l++]
          }
          r.toLong()-l+1
      }
  }
}