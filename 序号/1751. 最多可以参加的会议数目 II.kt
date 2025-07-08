class Solution {
  fun bisect(event:Array<IntArray>,right:Int, startDate:Int):Int {
      var l = -1
      var r = right
      while(l+1<r){
          var m = (l+r)/2
          if(event[m][1]<startDate) l=m
          else r=m
      }
      return l
  }
  fun maxValue(events: Array<IntArray>, k: Int): Int {
      // 参加最多k个会议，找价值最大值。会议要从头参加到尾
      val n = events.size
      // f[i][j] 前i个会议[0,i)，参加其中j个的最大值
      val f =Array(n+1){ IntArray(k+1) }
      events.sortWith { a,b->a[1]-b[1] } // 后面用2分找结束时间
      events.forEachIndexed{i,(start,end,value) ->
          val p = bisect(events,i,start)
          for (j in 1..k){
              f[i+1][j]=max(f[i][j],f[p+1][j-1]+value)
          }
      }
      return f[n][k]
  }
}







