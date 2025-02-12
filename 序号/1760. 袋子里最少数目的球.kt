class Solution {
  fun minimumSize(nums: IntArray, maxOperations: Int): Int {
      // 最小最大问题用二分猜答案
      var l = 0
      var r = nums.max()+1
      while (l+1<r){
          val m = (l+r)/2
          // 操作完之后，最大的数为m。 现在把nums[i]切开，[1,m]的操作数为0次，(m,2m],操作数为1
          val ops = nums.sumOf { (it-1)/m }
          if (ops>maxOperations) l=m
          else r=m
      }
      return r
  }
}