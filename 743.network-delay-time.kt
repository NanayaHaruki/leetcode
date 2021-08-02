class Solution {
    /**
     * k n [1,100]
     * 距离 [0,100]
     * */
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // 找k到所有节点的最大值，用数组保存k到每个点的距离，找最大，如果为初始值则k到不了，返回-1
        // dijkstra算法，每次找离k最近的点x，用x到每个点的距离+k到x的距离  与k直接到每个点的距离进行比较，保留小的那个

        // 将times更换为二维数组存储x到y的距离 graph[1][2]表示点1到点2的距离
        val max = 101
        val graph = Array(n + 1) { IntArray(n + 1) { max } }
        for ((p1, p2, distance) in times) {
            graph[p1][p2] = distance
        }

        val distanceArr = IntArray(n + 1) { max }  // distanceArr[1]表示点1到k的距离
        distanceArr[k] = 0 // k到自己距离为0
        val used = BooleanArray(n + 1) { false }
        for (i in 1..n) {
            // 找离k最近的点
            var x = -1 //没用过的离k最近的点
            for (j in 1..n) {
                if (!used[j] && (x == -1 || distanceArr[j] < distanceArr[x])) {
                    x = j
                }
            }
            used[x] = true
            // 通过点x通向其他点的距离，更新k通向其他点的距离
            for (m in 1..n) {
                if (distanceArr[m] > distanceArr[x] + graph[x][m]) {
                    distanceArr[m] = distanceArr[x] + graph[x][m]
                }
            }
        }

        // 计算最大距离
        var ans = 0
        for (i in 1..distanceArr.lastIndex) {
            if (distanceArr[i] == max) return -1 // 有初始值，说明k到不了这里，直接返回
            if (distanceArr[i] > ans) ans = distanceArr[i]
        }
        return ans
    }
}