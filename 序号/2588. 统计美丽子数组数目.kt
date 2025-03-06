class Solution {
  fun beautifulSubarrays(nums: IntArray): Long {
      // 两数之和的思路，数据量1e5必定无法O(n^2)
      val d = mutableMapOf<Int,Int>()
      var a = 0
      var ans = 0L
      for(b in nums){
          a = a xor b
          if(a==0) {
              ++ans
          }
          if(d.contains(a)){ // 如果前面出现过，说明中间这一段的异或和是0
              val c =d[a]!!
              ans+=c
              d[a]=c+1
          }else{
              d[a]=1
          }
      }
      return ans
  }
}