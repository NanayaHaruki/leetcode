class Solution {
  fun sumDigitDifferences(nums: IntArray): Long {
      // 总共9个数字，百位上1出现了2次，那每个1都提供了7次数位不同，
      // 统计所有数字在位数上的个数后累计计算

      val len = nums[0].toString().length
      val n = nums.size
      val f = Array(len){IntArray(10)}

      for(i in nums){
          val s = i.toString()
          for(j in 0 until len){
              f[j][s[j]-'0']++
          }
      }
      var ans = 0L
      for(intarr in f){
          for(j in intarr){
              ans+= j.toLong()*(n-j)
          }
      }
      return ans/2
  }
}