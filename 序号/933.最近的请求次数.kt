class RecentCounter() {
  private var queue = ArrayDeque<Int>()
  fun ping(t: Int): Int {
    queue.addLast(t)
    while (queue.isNotEmpty()) {
      val first = queue.peekFirst()
      if (first < t - 3000) queue.removeFirst()
      else break
    }
    return queue.size
  }
}