fun minJumps(arr: IntArray): Int {
    // 从0 开始跳到最后一位  问最短路径 ，每次只能左跳、右跳、等值跳
    // 搞个数组记录到达每个点的最短路径，等值只记录第一次，避免重复
    val n = arr.size
    val visited = BooleanArray(n)
    // 记录等值和索引对应关系
    val dict = mutableMapOf<Int, MutableList<Int>>()
    for (i in arr.indices) {
        var idxList = dict[arr[i]]
        if (idxList == null) idxList = mutableListOf()
        idxList.add(i)
        dict[arr[i]] = idxList
    }
    // 记录到达每个点的最短路径  pair为 index to step
    val q = ArrayDeque<Pair<Int, Int>>()
    q.offerLast(0 to 0)
    visited[0] = true
    while (q.isNotEmpty()) {
        val (idx, step) = q.poll()
        if (idx == n - 1) return step
        (idx - 1).apply {
            if (this >= 0 && !visited[this]) {
                visited[this] = true
                q.offerLast(this to step + 1)
            }
        }
        (idx + 1).apply {
            if (this < n && !visited[this]) {
                visited[this] = true
                q.offerLast(this to step + 1)
            }
        }

        val sameIndexList = dict[arr[idx]]
        if (sameIndexList != null) {
            dict[arr[idx]]?.forEach { equalIndex ->
                // 判断最大值来保证没有入队过
                if (!visited[equalIndex]) {
                    visited[equalIndex] = true
                    q.offerLast(equalIndex to step + 1)
                }
            }
            dict.remove(arr[idx])
        }
    }
    return -1
}