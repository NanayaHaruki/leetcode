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