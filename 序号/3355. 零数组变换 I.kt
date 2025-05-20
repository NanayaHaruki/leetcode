class Solution {
  fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
      // 区间修改，单点查询。 每次查询范围内的数都可以减1,被查几次就可以减几次
      // 统计nums[i]被查询次数超过当前值就可以被置0
      val n = nums.size
      val dif = IntArray(n+1)
      for((l,r) in queries) {
          dif[l]++
          dif[r+1]--
      }
      val ps = IntArray(n+1)
      ps[0]=dif[0]
      for(i in 1..n){
          ps[i] = ps[i-1]+dif[i]
      }
      for(i in 0 until n){
          if(nums[i]>ps[i]) return false
      }
      return true
  }
}