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