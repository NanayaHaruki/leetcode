import kotlin.math.abs

class DetectSquares() {
    /** 根据给定点的x ，查询有多少种y来计算边长的可能性 */
    val xDict = mutableMapOf<Int, MutableSet<Int>>()

    /** 根据坐标查询点的数量 */
    val pDict = mutableMapOf<String, Int>()
    fun add(point: IntArray) {
        val (x, y) = point
        var ySet = xDict[x]
        if (ySet == null) ySet = mutableSetOf<Int>()
        ySet.add(y)
        xDict[x] = ySet

        var pointCount = pDict["${x}_$y"] ?: 0
        pDict["${x}_$y"] = ++pointCount
    }

    fun count(point: IntArray): Int {
        var ans = 0
        val (x1, y1) = point
        val y1Set = xDict[x1] ?: return 0
        // 遍历查找与x，y 纵坐标不同的第二个点，并计算出边长
        for (y2 in y1Set) {
            // 第2个点为 x1 y2
            // 计算边长
            if (y2 == y1) continue
            val cnt0 = pDict["${x1}_${y2}"] ?: 0
            val sizeLen = abs(y1 - y2)
            // 后面就不用遍历了，可以计算出来符合的另外2点坐标
            intArrayOf(1, -1).forEach {
                val x3 = x1 + it * sizeLen
                val y3 = y1
                val x4 = x3
                val y4 = y2
                val cnt1 = pDict["${x3}_$y3"] ?: 0
                val cnt2 = pDict["${x4}_$y4"] ?: 0
                ans += cnt0 * cnt1 * cnt2
            }
        }
        return ans
    }
}