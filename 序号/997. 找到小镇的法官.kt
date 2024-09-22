class Solution {
  fun findJudge(n: Int, trust: Array<IntArray>): Int {
      // n个人，法官会受相信n-1次，统计一下次数; 再遍历时再统计下候补有没有信过别人
      val d = BooleanArray(n+1)
      val cnts = IntArray(n+1)
      for(i in 0 until trust.size){
          val (a,b) = trust[i]
          d[a]=true
          cnts[b]++
      }
      for(i in 1..n){
          val c = cnts[i]
          if(c==n-1 && !d[i])
              return i
      }
      return -1
  }
}