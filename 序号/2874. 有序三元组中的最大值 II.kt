class Solution {
  fun maximumTripletValue(nums: IntArray): Long {
      // 考虑中间的数 ：找一个数前面和后面都最大的
      // 考虑后面的数： 找前面的差值最大的，同时维护最大值和差值
      var mx = 0
      var dif = 0
      var ans = 0L
      for(x in nums){
          ans = max(ans,1L*dif*x)
          dif = max(dif,mx-x)
          mx = max(mx,x)
      }
      return ans
  }
}