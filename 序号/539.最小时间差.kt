fun findMinDifference(timePoints: List<String>): Int {
    // HH：MM 转成到0的空间，排序，再次遍历统计最小间隔
    val pq = PriorityQueue<Int>()
    timePoints.forEach {
        val hour = it.substring(0,2).toInt()
        val minute = it.substring(3).toInt()
        val totalMinute = hour*60+minute
        pq.offer(totalMinute)
        pq.offer(totalMinute+24*60) // 存在跨天的情况，每个值都输入2遍
    }
    var pre = -1
    var ans = Int.MAX_VALUE
    while (pq.isNotEmpty()) {
        if (pre==-1) pre = pq.poll()
        else {
            val poll = pq.poll()
            ans = minOf(ans,poll-pre)
            pre = poll
        }
    }
    return ans
}