/** 根据分数返回名词 ，1～3特殊处理 用堆就行 */
fun findRelativeRanks(score: IntArray): Array<String> {
    val pq = PriorityQueue<Pair<Int, Int>>() { p1, p2 -> p2.first - p1.first }
    for (i in score.indices) {
        pq.offer(score[i] to i)
    }
    val ans = Array<String>(score.size) { "" }
    var i = 0
    while (pq.isNotEmpty()) {
        val (_, index) = pq.poll()
        i++
        ans[index] = when (i) {
            1 -> "Gold Medal"
            2 -> "Silver Medal"
            3 -> "Bronze Medal"
            else -> i.toString()
        }
    }
    return ans
}