class Solution {
  fun maxDistance(position: IntArray, m: Int): Int {
      // 最小最大问题，无脑二分
      position.sort()
      val limit = position.last()-position.first()+1
      var l = 0
      var r = limit
      while(l+1<r){
          val mid = (l+r) shr 1 // 判断两球间隔m 可不可以
          var cnt = 1
          var prev = position[0]
          for(i in 1 until position.size){
              val diff = position[i] - prev
              if(diff >= mid){
                  if(++cnt==m) break // ok，所有球都放下了
                  prev = position[i] // 满足条件，找下一个球
              }
          }
          if(cnt==m){
              l=mid
          }else{
              r=mid
          }

      }
      return l
  }
}