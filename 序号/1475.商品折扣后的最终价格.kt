fun finalPrices(prices: IntArray): IntArray {
  // 最右边的没有折扣，倒序遍历，遍历到i，找栈顶元素，比i大的弹栈，保留小的，计算差值
  val l = ArrayDeque<Int>()
  l.add(0) // 价格都是整数，在末尾添加个0，方便求差，避免遍历时一直判断队列是否为空
  val ans = IntArray(prices.size)
  for (i in prices.size - 1 downTo 0) {
    val p = prices[i]
    while (l.size>1 && l.first > p)
      l.removeFirst()
    ans[i] = p - l.first
    
    l.addFirst(p)
  }
  return ans
}