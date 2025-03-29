class Solution {
  fun longestCycle(edges: IntArray): Int {
      // 找最大环，topo过滤出在环里的点
      // 每个点出度为1，最多在一个环里。遍历找最大的就是
      val n = edges.size
      val ind = IntArray(n)
      edges.forEach{x->
          if(x>=0) ind[x]++
      }
      val l = mutableListOf<Int>()
      val q = ArrayDeque<Int>()
      ind.forEachIndexed { i, x -> if(x==0) q.add(i)  }
      while(q.isNotEmpty()){
          val u = q.removeFirst()
          l.add(u)
          val v = edges[u]
          if(v>=0 && --ind[v]==0) q.add(v)
      }
      if(l.size==n ) return -1 // 没有环
      val circleNodes = (0 until n).toMutableSet()
      l.forEach { circleNodes.remove(it) }
      var ans = 0
      while(circleNodes.isNotEmpty()){
          // 开始一个环
          var len = 1
          val start = circleNodes.first()
          var u = start
          circleNodes.remove(u)
          while(edges[u]!=start){
              u=edges[u]
              ++len
              circleNodes.remove(u)
          }
          if(len>ans) ans = len
      }
      return ans
  }
}