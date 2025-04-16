class Solution {
  fun countGood(nums: IntArray, k: Int): Long {
      val m = mutableMapOf<Int,Int>() // 记录不同数字出现多少次
      // 要求有k对 位置不同 值相同的数
      // i 有a对，取决于 i-1 有b对 加上 与i相同的数字c个可以多出c对，若c+b>=k，则当前左右边界的子数组满足要求
      var l = 0
      var ans = 0L
      var pairs = 0L
      val n = nums.size
      for(r in nums.indices){
          val cnt = m[nums[r]]?:0
          pairs+=cnt
          m[nums[r]]=m.getOrDefault(nums[r],0)+1
          while(pairs>=k){
              ans+=n-r
              m[nums[l]]=m[nums[l]]!!-1
              pairs-=m[nums[l]]!!
              ++l
          }

      }
      return ans
  }
}