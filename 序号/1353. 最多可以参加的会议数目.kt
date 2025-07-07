class Solution {
  fun maxEvents(events: Array<IntArray>): Int {
      // 参加已经开始的，结束最早的会
      // 按开始时间排序，开始时间相同，按结束早的先
      val mx = events.maxOf { it[1] }
      val groups = Array<MutableList<Int>>(mx+1){mutableListOf()}
      for (e in events) groups[e[0]].add(e[1])
      var ans = 0
      val pq = PriorityQueue<Int>()
      for (i in 1..mx){
          // 删除过期的会议
          while(pq.isNotEmpty() && pq.peek()<i) pq.poll()
          // 将开始的会议入堆
          for(endDate in groups[i]) pq.offer(endDate)
          if (pq.isNotEmpty()) {
              ans++
              pq.poll()
          }
      }
      return ans
  }
}