/** 返回数字连续的最大长度 */
fun longestConsecutive(nums: IntArray): Int {
  // 去重
  val set = mutableSetOf<Int>()
  var ans = 0
  for (i in nums) set.add(i)
  for (i in set){
    if (set.contains(i-1)) continue // 如果包含小一个的数，最长答案必定不是以i为起始点的，直接跳过，找更小的
    var j = i+1
    var len = 1
    while (set.contains(j)){
      len++;j++
    }
    ans = maxOf(ans,len)
  }
  return ans
}