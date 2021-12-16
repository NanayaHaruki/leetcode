import kotlin.math.PI
import kotlin.math.atan2

class Solution {
    fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        // 在location的位置，旋转自身，观测范围是angle，查看最多能看到多少个点
        // 先求出每个点到location的斜率 转换成到X轴的角度，根据点与location的相关位置以及斜率判断该点在location的第几象限，将角度全部转成0～2pi
        // 将角度排序，从小角度a1开始，遍历直到未超过angle的点a2，得出能看到的点。a1+1后，a2往后继续找，更新答案，a2遍历完所有点退出循环。
        val (x, y) = location
        val n = points.size
        val angleF = angle * PI / 180
        val angleList = mutableListOf<Double>()//存的是每个点到X轴的角度
        var samePoint = 0 //与location相同，不管什么角度都能看到，不参与后面逻辑
        for (i in points.indices) {
            val (px, py) = points[i]
            // 同一个点
            if (px == x && py == y) {
                samePoint++
                continue
            }
            // 垂直的，斜率无限大的情况
            if (px - x == 0) {
                angleList.add(
                    if (py > y) PI / 2f
                    else 1.5 * PI
                )
                continue
            }
            angleList.add(atan2(1.0 * (py - y), 1.0 * (px - x)))

        }
        for (i in angleList.indices) {
            angleList.add(angleList[i] + 2 * PI)
        }
        angleList.sort()
        var maxAns = 0
        var r = 0
        for (i in 0 until angleList.size) {
            val currAngle = angleList[i]+angleF
            while (r < angleList.size && angleList[r] <= currAngle) {
                r++
            }
            if (r-i > maxAns)
                maxAns = r-i
        }
        return maxAns + samePoint
    }
}