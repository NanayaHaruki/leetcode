fun maxChunksToSorted(arr: IntArray): Int {
  // 数可以重复了，且大小不定
  // 题目需要分成最多的块，用栈维护每个块的最大值，右边出现的数要大于栈顶的块，则可独立成块。
  // 如果小于栈顶，要融合进左边的块，因为栈顶更大，所以栈顶依旧在栈顶，但栈内《=新元素的可以继续待在栈内，作为新元素左边的块，其他的出栈。
  val q = ArrayDeque<Int>()
  for (i in arr) {
    if (q.isEmpty()) {
      q.add(i)
      continue
    }
    val top = q.last
    if (top <= i) {
      q.add(i)
    } else {
      while (q.isNotEmpty() && q.last > i) q.removeLast()
      q.add(top)
    }
  }
  return q.size
}