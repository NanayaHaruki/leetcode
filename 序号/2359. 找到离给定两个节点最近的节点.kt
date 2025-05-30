class Solution {
  fun dijkstra(g: Array<MutableList<Int>>, node: Int): IntArray {
      val dis = IntArray(g.size) { Int.MAX_VALUE }
      dis[node]=0
      val s = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
      s.offer(intArrayOf(0, node))
      while (s.isNotEmpty()) {
          val (d, u) = s.poll()
          for (v in g[u]) {
              if (dis[v] > dis[u] + 1) {
                  dis[v] = dis[u] + 1
                  s.offer(intArrayOf(dis[v], v))
              }
          }
      }
      return dis
  }

  fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
      val n = edges.size
      val g = Array(n) { mutableListOf<Int>() }
      edges.forEachIndexed { i, x -> if(x!=-1) g[i].add(x) }
      val dis1 = dijkstra(g, node1)
      val dis2 = dijkstra(g, node2)

      var idx = -1
      var v = Int.MAX_VALUE
      for (i in 0 until n){
          val mx = max(dis1[i],dis2[i])
          if(mx<v){
              v=mx
              idx=i
          }
      }
      return idx
  }
}