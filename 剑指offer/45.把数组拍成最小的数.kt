/** 求数组重排后连起来数字最小 */
fun minNumber(nums: IntArray): String {
  val sb = StringBuilder()
  val q = PriorityQueue<String>(Comparator{o1,o2->  (o1+o2).compareTo(o2+o1)})
  for (n in nums) q.offer(n.toString())
  while (q.isNotEmpty()) sb.append(q.poll())
  return sb.toString()
}

/** 求数组重排后连起来数字最小 */
fun minNumber(nums: IntArray): String {
  val sb = StringBuilder()
  val a = Array<String>(nums.size) { nums[it].toString() }
  a.sortWith(Comparator { o1, o2 -> (o1 + o2).compareTo(o2 + o1) })
  for (n in a) sb.append(n)
  return sb.toString()
}