class Solution {
  lateinit var f:IntArray
  var cnt = 0
  fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
      // 从后往前找，发现有入度2的，删掉后判断能成树，就是答案
      // 重新找入度为1的，删掉后能成树，就是答案
      val n = edges.size
      f = IntArray(n+1)
      val ind = IntArray(n+1)
      for((a,b) in edges){
          ind[b]++
      }
      for (i in n-1 downTo 0){
          if (ind[edges[i][1]]==2 && check(edges,i))
              return edges[i]
      }
      for(i in n-1 downTo 0){
          if(ind[edges[i][1]]==1 && check(edges,i))
              return edges[i]
      }
      return IntArray(0)
  }

  fun find(x:Int):Int{
      if (x!=f[x]){
          f[x]=find(f[x])
      }
      return f[x]
  }
  fun connect(u:Int,v:Int){
      val fu = find(u)
      val fv = find(v)
      if(fu==fv) return
      cnt--
      f[fv]=fu
  }
  /** 当idx这条边不存在，判断能否成树 */
  fun check(e:Array<IntArray>,idx:Int):Boolean{
      for(j in 1..e.size){
          f[j]=j
      }
      cnt=e.size
      e.forEachIndexed { index, (u,v) ->
          if(index!=idx) {
              connect(u,v)
          }
      }
      return cnt==1
  }
}