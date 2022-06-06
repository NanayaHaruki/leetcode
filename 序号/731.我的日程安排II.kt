class MyCalendarTwo() {
  val d = TreeMap<Int,Int>()
  fun book(start: Int, end: Int): Boolean {
    // 区间修改，单点查询（其实是区间查询了，线段树太麻烦了，用差分做）
    // 先直接记录book，记录完了，利用差分计算是否有预定数量大于1的，有的说明重复了，本地预定取消即可
    // 因为不重合的，预定次数始终是1 -1 1 -1 1 -1 这样
    
    //---729 一样，不用导致三重预定，就是可以重复预定2次，把729的限制1，改成2即可-----
    d[start]=d.getOrDefault(start,0)+1
    d[end]=d.getOrDefault(end,0)-1
    
    var curValue = 0;var canBook = true
    for ((k,v) in d){
      curValue+=v
      if (curValue>2) {
        canBook=false
        break
      }
    }
    if (canBook) return true
    else {
      // 重复预定了，还原记录
      d[start] = d[start]!! -1
      d[end] = d[end]!!+1
      return false
    }
  }
}