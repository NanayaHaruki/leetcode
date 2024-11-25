class Solution {
  fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val g = Array(n+1){ mutableListOf<IntArray>() }
    for ((u,v,w) in times){
      g[u].add(intArrayOf(v,w))
    }
    val dis = IntArray(n+1){Int.MAX_VALUE}
    dis[k]=0
    val q = PriorityQueue<IntArray>(){a,b-> a[0]-b[0]}
    val vis = BooleanArray(n+1)
    q.add(intArrayOf(0,k))
    while(q.isNotEmpty()){
      val (_,u) = q.poll()!!
      vis[u]=true
      for((v,w) in g[u]){
        if (dis[v]>dis[u]+w){
          dis[v]=dis[u]+w
          q.add(intArrayOf(dis[v],v))
        }
      }
    }
    var ans = 0
    for (i in 1 until dis.size){
      if (dis[i]==Int.MAX_VALUE) return -1
      if (dis[i]>ans) ans = dis[i]
    }
    return ans
  }
}