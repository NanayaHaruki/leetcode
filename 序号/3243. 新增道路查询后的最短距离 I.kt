class Solution {
  private fun find(g:Array<MutableList<Int>>):Int{
    val dis = IntArray(g.size){Int.MAX_VALUE}
    dis[0]=0
    val vis = BooleanArray(g.size)
    val q = PriorityQueue<IntArray>{a,b->a[0]-b[0]}
    q.add(intArrayOf(0,0))

    while(q.isNotEmpty()){
      val (w,u) = q.poll()!!
      if(vis[u]) continue
      vis[u]=true
      for(v in g[u]){
        if(dis[v]>dis[u]+1){
          dis[v]=dis[u]+1
          q.add(intArrayOf(dis[v],v))
        }
      }
    }
    return dis.last()
  }
  fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val g = Array(n){mutableListOf<Int>()}
    for(i in 0 until n-1){
      g[i].add(i+1)
    }
    val ans = IntArray(queries.size)
    queries.forEachIndexed { i, (u, v) ->
      g[u].add(v)
      ans[i]=find(g)
    }
    return ans
  }
}