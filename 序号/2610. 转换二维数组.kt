class Solution {
  fun findMatrix(nums: IntArray): List<List<Int>> {
      // 每行数不同
      // 行数尽量少
      // 统计数字出现个数，最多的就是行数
      val d = mutableMapOf<Int,Int>()
      for(x in nums){
          d.merge(x,1,Integer::sum)
      }

      val ans = mutableListOf<List<Int>>()
      while(d.isNotEmpty()){
          ans.add(d.keys.toList())
          for (k in ans.last()){
              d.merge(k,-1){a,b->if(a+b==0)null else a+b}
          }
      }
      return ans
  }
}