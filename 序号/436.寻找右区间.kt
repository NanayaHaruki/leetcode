fun findRightInterval(intervals: Array<IntArray>): IntArray {
  // 右区间为 一个区间的start >= 另一区间的end，返回所有区间的右区间的索引
  // 用treemap记录所有区间的start和索引，遍历区间拿到大于右区间的值，从map中找到最近的左区间
  val dict = sortedMapOf<Int,Int>()
  intervals.forEachIndexed { index, ints ->
    dict[ints[0]]=index
  }
  val ans = IntArray(intervals.size){-1}
  intervals.forEachIndexed { index, ints ->
    for ((key,value) in dict){
      if (key>=ints[1]){
        ans[index]=value
        break
      }
    }
  }
  return ans
}