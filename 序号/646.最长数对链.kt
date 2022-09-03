fun findLongestChain(pairs: Array<IntArray>): Int {
  // 贪心 数组按第2个数排序，这样从左到右遍历，第2个数递增。同时判断是否第一个数大于前面的数即可
  pairs.sortWith(object:Comparator<IntArray> {
    override fun compare(o1: IntArray, o2: IntArray): Int {
      return o1[1] - o2[1]
    }
  })
  var cur = Int.MIN_VALUE;var ans = 0
  for ((x,y) in pairs){
    if (x>cur){
      cur = y
      ans++
    }
  }
  return ans
}