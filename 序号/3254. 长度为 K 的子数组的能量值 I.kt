class Solution {
  fun resultsArray(nums: IntArray, k: Int): IntArray {
      // 记录开始递增的位置，如果断了从头开始
      // 递增长度》=k，就是符合条件的子数组
      var cnt = 0
      val n = nums.size
      val ans = IntArray(n-k+1){-1}
      nums.forEachIndexed{i,x->
          cnt = if(i==0 || nums[i]==nums[i-1]+1) cnt+1
          else 1
          if(cnt>=k) ans[i-k+1]=x
      }
      return ans
  }
}