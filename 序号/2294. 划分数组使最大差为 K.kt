class Solution {
  fun partitionArray(nums: IntArray, k: Int): Int {
      // 因为是序列中任意元素差都要  «=k，所以顺序无所谓
      nums.sort()
      var cnt = 1
      var mn = nums[0]
      for(i in nums.indices){
          val x = nums[i]
          if(x-mn<=k) continue
          ++cnt
          mn=x
      }
      return cnt
  }
}