class Solution {
  fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
      // 递增返回索引集合，索引的+-k范围内存在值为key的数
      // 直接找到key所在的索引，将附近k的索引放进答案
      val ans = mutableListOf<Int>()
      val n = nums.size
      nums.forEachIndexed{i,x->
          if(x==key){
              val l = if(ans.isEmpty()) max(0,i-k) else max(i-k,ans.last()+1)
              val r = min(i+k,n-1)
              for(j in l..r) ans.add(j)
          }
      }
      return ans
  }
}