class Solution {

  /** 数位dp 状态有logn，每个状态logn ,总共 log2N */
  fun countLargestGroup(n: Int): Int {
    val strN = n.toString()
    val m = strN.length
    val limit = strN.map { it-'0' }

    // i 最多为m，n最大10000,m最多到5,3bit
    // left最多m*9,最大36,6bit
    // highlimit 1bit
    val mem = mutableMapOf<Int,Int>()
    fun dfs(i:Int,left:Int,highLimit:Boolean):Int{
        if (i==m){
            return if (left==0) 1 else 0
        }
        val key = i.shl(7).or(left.shl(1)).or(if (highLimit) 1 else 0)
        if (mem.contains(key)) return mem[key]!!
        val hi = if (highLimit) limit[i] else 9
        var res = 0
        for (j in 0 .. min(left,hi)){
            res+=dfs(i+1,left-j,highLimit && j==hi)
        }
        mem[key]=res
        return res
    }
    var mxCnt = 0
    var groupCnt = 0
    for (t in 1..36){
        val cnt = dfs(0,t,true)
        if (cnt>mxCnt){
            mxCnt=cnt
            groupCnt=1
        }else if(cnt==mxCnt){
            groupCnt++
        }
    }
    return groupCnt
}

  /** 暴力 nlogn */
  fun countLargestGroup(n: Int): Int {
      val m = mutableMapOf<Int,Int>()
      for(i in 1 .. n){
          var j = i
          var s = 0
          while(j>0){
              s+=j%10
              j/=10
          }
          m.merge(s,1,Int::plus)
      }
      var mxV = 0
      var cnt = 0
      for((k,v) in m.entries){
          if (v>mxV){
              mxV=v
              cnt=1
          }else if(v==mxV){
              cnt++
          }
      }
      return cnt
  }
}