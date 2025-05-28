class Solution {
  fun links(g:Array<out List<Int>>,i:Int,k:Int):Int{
      if(k<0) return 0
      val vis = BooleanArray(g.size)
      val q = ArrayDeque<Int>().apply{add(i)}
      var ans = 0
      var d = 0
      while(q.isNotEmpty()){
          val sz = q.size
          ans+=sz
          if(++d<=k){
              for(j in 0 until sz){
                  val u = q.removeFirst()
                  vis[u]=true
                  for(v in g[u]){
                      if(vis[v]) continue
                      q.add(v)
                  }
              }
          }else{
              break
          }
      }
      return ans
  }
  fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
      // 找到tree1中每个点连接距离<=k的节点数
      // 找到tree2中每个点连接距离<k的节点数，让t1连接最大的点
      val n = edges1.size+1
      val m = edges2.size+1
      val g1 = Array(n){mutableListOf<Int>()}
      val g2 = Array(m){mutableListOf<Int>()}
      for((a,b) in edges1){
          g1[a].add(b)
          g1[b].add(a)
      }
      for((a,b) in edges2){
          g2[a].add(b)
          g2[b].add(a)
      }
      val mx1 = IntArray(n) // tree1中每个点距离<=k的节点数量
      for(i in 0 until n){
          mx1[i]=links(g1,i,k)
      }
      val mx2 = IntArray(m)
      for(i in 0 until m){
          mx2[i]=links(g2,i,k-1)
      }
      return mx1.apply{
          val mxOfMx2 = mx2.max()
          for(i in 0 until n) mx1[i]+=mxOfMx2
      }
  }
}