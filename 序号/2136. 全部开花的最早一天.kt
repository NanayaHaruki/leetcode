class Solution {
  fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    // 返回全部开花最早的一天
    val n = plantTime.size
    // 先种长得慢的
    val q = PriorityQueue<IntArray>{
      i,j->
      if(i[0]==j[0])  i[1]-j[1]
      else  j[0]-i[0]
    }
    for(i in 0 until n){
      q.add(intArrayOf(growTime[i],i))
    }
    var ans = 0
    var day = 0
    while(q.isNotEmpty()){
      val (time,idx) = q.poll()!!
      day+=plantTime[idx]
      ans= maxOf(ans,day+time)
    }
    return ans
  }
}