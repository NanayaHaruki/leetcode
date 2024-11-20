class Solution {
  fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
      val ans = IntArray(queries.size)
      val d = mutableMapOf<Int,Int>()
      for (i in 0 until n-1) d[i]=i+1
      queries.forEachIndexed { index, (a,b) ->
          if (d.contains(a) && b>d[a]!!){
              // 删除[A,B]中所有区间
              var c = a
              while (c<b){
                  c = d.remove(c)!!
              }
              d[a]=b
          }
          ans[index]=d.size
      }
      return ans
  }
}