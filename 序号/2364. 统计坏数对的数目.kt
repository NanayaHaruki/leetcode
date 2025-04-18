class Solution {
  fun countBadPairs(nums: IntArray): Long {
      val n = nums.size
      val m = mutableMapOf<Int,Int>() // 统计值与索引的差，后续如何碰到同样的差，则这是个好数对
      var cnt = 0L // 统计好数对的个数
      // j-i = nums[j]-nums[i]  ==>  nums[i]-i = nums[j]-j
      nums.forEachIndexed{i,x->
          cnt += m.getOrDefault(x-i,0)
          m.merge(x-i,1,Int::plus)
      }
      return n.toLong()*(n-1)/2-cnt
  }
}