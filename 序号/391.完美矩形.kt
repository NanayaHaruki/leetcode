import kotlin.math.abs
class Solution {
    fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
        // 小矩形能组成大矩形，小矩形的顶点只有4个点是大矩形的顶点，他们只出现一次，
        // 其他点都应该出现偶数次（共边）
        // 找四个只出现一次的点
        val dict = mutableMapOf<String, Int>()
        var areaSum = 0
        for ((x1, y1, x2, y2) in rectangles) {
            areaSum += abs((x1 - x2) * (y1 - y2))
            val p1 = "${x1}_${y1}"
            val p2 = "${x2}_${y2}"
            val p3 = "${x1}_${y2}"
            val p4 = "${x2}_${y1}"
            dict[p1] = dict.getOrDefault(p1, 0) + 1
            dict[p2] = dict.getOrDefault(p2, 0) + 1
            dict[p3] = dict.getOrDefault(p3, 0) + 1
            dict[p4] = dict.getOrDefault(p4, 0) + 1
        }
        // 4个点出现1次，其他点出现偶数次
        val points = mutableListOf<IntArray>()
        for ((k, v) in dict) {
            if (v == 1) {
                val arr = k.split("_").map { it.toInt() }
                points.add(intArrayOf(arr[0], arr[1]))
            } else if (v % 2 == 1) {
                return false
            }
        }
        if (points.size != 4) {
            return false
        }
        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        points.forEach {
            minX = minOf(minX, it[0])
            maxX = maxOf(maxX, it[0])
            minY = minOf(minY, it[1])
            maxY = maxOf(maxY, it[1])
        }
        // 如果有4个，判断小矩形的面积与大矩形面积是否相等
        return areaSum == (maxX - minX) * (maxY - minY)
    }
}