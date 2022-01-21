fun canReach(arr: IntArray, start: Int): Boolean {
    val isVisited = BooleanArray(arr.size)
    val q = ArrayDeque<Int>()
    q.offer(start)
    while (q.isNotEmpty()) {
        val idx = q.poll()
        if (arr[idx] == 0) return true
        isVisited[idx] = true
        val step = arr[idx]
        (idx - step).apply { if (this >= 0 && !isVisited[this]) q.offerLast(this) }
        (idx + step).apply { if (this < arr.size && !isVisited[this]) q.offerLast(this) }
    }
    return false
}