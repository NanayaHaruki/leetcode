class Solution {
  fun semiOrderedPermutation(nums: IntArray): Int {
      // 如果n在1右边，各自统计返回距离
      // 否则，距离和减1，因为他俩相遇时一次反转可以同时减少2者到目的地的距离
      var a = 0
      var b = 0
      val n = nums.size
      nums.forEachIndexed{i,x-> 
      if(x==1) a=i
      else if(x==n) b=i
      }
      return if(a<b) a+n-1-b else a+n-2-b
  }
}