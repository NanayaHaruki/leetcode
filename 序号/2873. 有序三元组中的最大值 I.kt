class Solution {
  fun maximumTripletValue(nums: IntArray): Long {
      // 都是正数，不考虑两个负数之积为最大的情况
      // 枚举中间的数，找两边最大的数
      var mx = nums[0]
      val n = nums.size
      val left = IntArray(n)
      val right = IntArray(n)
      for(i in 1 .. n-2){
          left[i]=mx
          mx = max(mx,nums[i])
      }
      mx = nums.last()
      for(i in n-2 downTo 1){
          right[i]=mx
          mx = max(mx,nums[i])
      }
      var ans = 0L
      for(i in 1 .. n-2){
          ans = max(ans,1L*(left[i]-nums[i])*right[i])
      }
      return ans
  }
}