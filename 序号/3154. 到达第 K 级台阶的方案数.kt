class Solution {
  val mem = mutableMapOf<Long, Int>()
  var k = 0
  fun dfs(s: Int, j: Int, d: Int): Int {
      if (s > k + 1) return 0
      val key = (s.toLong() shl 32) or (j.toLong() shl 1) or d.toLong()
      if(mem.contains(key)) return mem[key]!!
      var ans = if(s==k) 1 else 0
      if(s>0 && d==0){ // 如果到s不是下降的，那么可以从s往下降
          ans+=dfs(s-1,j,1)
      }
      ans+=dfs(s+(1 shl j),j+1,0)
      mem[key]=ans
      return ans
  }

  fun waysToReachStair(_k: Int): Int {
      k = _k
      return dfs(1,0,0)
  }
}