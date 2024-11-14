class Solution {
  fun countGoodNodes(edges: Array<IntArray>): Int {
      val n = edges.size+1
      val d = Array<MutableList<Int>>(n){mutableListOf<Int>()}
      for((a,b) in edges){
          d[a].add(b)
          d[b].add(a)
      }
      var ans = 0
      /** 返回节点数 */
      fun dfs(fv:Int,cv:Int):Int{
          if(d[cv].size==1 && d[cv][0]==fv) {
              ans++
              return 1
          } // 叶子节点是好节点
          var isGoodNode = true
          var nodeCnt = 0
          var cnt = 1
          for(sv in d[cv]){
              if(sv==fv) continue
              val curNodeAmount = dfs(cv,sv)
              if(nodeCnt==0){
                  nodeCnt=curNodeAmount
              }else{
                  if(isGoodNode && nodeCnt!=curNodeAmount) isGoodNode=false
              }
              cnt+=curNodeAmount
          }
          if(isGoodNode) ans++
          return cnt
      }
      dfs(-1,0)
      return ans
  }
}