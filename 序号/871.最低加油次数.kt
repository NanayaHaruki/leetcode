fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
  // 贪心大根堆，油量为空前一直往前走，将加油站的油量添加进大根堆，当油空了，从大根堆顶弹出油最多的加油站来加油，走到终点时统计次数即可
  val pq = PriorityQueue<Int>(){i,j->j-i}
  var curOil=startFuel // 当前有的油
  var ans = 0;var oilIndex = 0
  while(curOil<target){
    // 找出经过的加油站
    while (oilIndex<stations.size&& stations[oilIndex][0]<=curOil){
      pq.add(stations[oilIndex][1])
      oilIndex++
    }
    if (pq.isEmpty()) return -1
    curOil+=pq.poll()
    ans++
  }
  return ans
}

/**
 * 2024/10/07
 * 
*/
class Solution {
  fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
      var remainFuel = startFuel // 还剩多少油
      var cnt = 0 // 加油的次数
      val pq = PriorityQueue<Int>(){i,j-> j-i}
      var i = 0
      while(remainFuel<target){
          while(i<stations.size && stations[i][0]<=remainFuel){
              pq.offer(stations[i][1])
              i++
          }
          if(pq.isNotEmpty()){
              remainFuel+=pq.poll()
              cnt++
          }else{
              return -1
          }
      }
      return cnt
  }
}