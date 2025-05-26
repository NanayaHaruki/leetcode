class Solution {
  fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
      val n = colors.length
      // 建表
      val g = Array(n){ mutableListOf<Int>() }
      val ins = IntArray(n) // 统计入度
      val s = ArrayDeque<Int>()

      for((u,v) in edges) {
          g[u].add(v)
          ins[v]++
      }
      for(i in 0 until n){
          if(ins[i]==0) s.add(i)
      }
      val os = s.toList()
      // 拓扑排序找环
      val l = mutableListOf<Int>()
      while (s.isNotEmpty()){
          val u = s.removeFirst()
          l.add(u)
          for(v in g[u]){ // u 被拿走，v的入度-1
              if(--ins[v]==0) s.add(v)
          }
      }
      if (l.size!=n) return -1

      val mem = mutableMapOf<Int,IntArray>()
      fun dfs(i:Int):IntArray{
          if(mem.contains(i)) return mem[i]!!
          // 以i为起点，共26种颜色最多出现次数
          val curColor = colors[i]-'a'
          val cnts = IntArray(26)
          for(j in g[i]){
              val colorCnts = dfs(j)
              for(k in 0 until 26){
                  cnts[k]=max(cnts[k],colorCnts[k])
              }
          }
          cnts[curColor]+=1
          mem[i]=cnts
          return cnts
      }

      return os.maxOf { dfs(it).max() }
  }
}