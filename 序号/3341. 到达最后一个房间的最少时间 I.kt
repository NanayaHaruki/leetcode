class Solution {
  fun minTimeToReach(moveTime: Array<IntArray>): Int {
      val m = moveTime.size
      val n = moveTime[0].size
      val q = PriorityQueue<IntArray>{a,b-> a[0]-b[0] }.apply { add(intArrayOf(0,0,0)) }
      val dis = Array(m){IntArray(n){Int.MAX_VALUE} }
      dis[0][0]=0
      val ds = intArrayOf(-1,0,1,0,-1)
      while(q.isNotEmpty()){
          val (d,r,c) = q.poll()
          if(d>dis[r][c]) continue
          // 更新这个点四周的到达时间
          for(di in 0 until 4){
              val nr = r + ds[di]
              val nc = c + ds[di+1]
              if (nr<0 || nr == m || nc < 0 || nc == n) continue
              val newDis = d.coerceAtLeast(moveTime[nr][nc])+1
              if(newDis<dis[nr][nc]){
                  dis[nr][nc]=newDis
                  q.offer(intArrayOf(newDis,nr,nc))
              }
          }

      }
      return dis.last().last()
  }
}