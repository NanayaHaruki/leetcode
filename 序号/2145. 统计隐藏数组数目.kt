class Solution {
  fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
      // 因为差值是固定的，第1个数固定则整个数组固定。问题转换成有多少种第一个数
      // 统计最低值和最高值在不在区间内
      var a = 0L
      var mn = 0L
      var mx = 0L
      for (d in differences){
          a+=d
          mn=min(mn,a)
          mx = max(mx,a)
      }
      return max(0,(1L+upper-lower-mx+mn).toInt())
  }
}