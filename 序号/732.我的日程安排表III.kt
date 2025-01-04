class MyCalendarThree() {
  private val dict = sortedMapOf<Int,Int>()
  fun book(start: Int, end: Int): Int {
    // 返回重合预定的最大次数，区间修改，单点查询==>差分
    dict[start]=(dict[start]?:0)+1
    dict[end]=(dict[end]?:0)-1
    
    var curValue =0;var ans = 0
    for ((k,v) in dict) {
      curValue+=v
      ans= maxOf(ans,curValue)
    }
    return ans
  }
}
/** 25/01/04 */
class MyCalendarThree() {
  private val d = TreeMap<Int,Int>()
  fun book(startTime: Int, endTime: Int): Int {
      d[startTime]=d.getOrDefault(startTime,0)+1
      d[endTime]=d.getOrDefault(endTime,0)-1
      var cur = 0
      var mx = 0
      for(v in d.values){
          cur+=v
          if(cur>mx) mx = cur
      }
      return mx
  }

}

/**
* Your MyCalendarThree object will be instantiated and called as such:
* var obj = MyCalendarThree()
* var param_1 = obj.book(startTime,endTime)
*/