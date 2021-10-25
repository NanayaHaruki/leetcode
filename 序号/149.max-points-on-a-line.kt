class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        var max = 2
        // 遍历数组，先用2点确定直线，再找第3点，看有多少在同一条直线上
        for (i in points.indices){
            val p1 = points[i]
            for (j in i+1..points.lastIndex){
                val p2 = points[j]
                var cnt = 2 // 一条直线至少2个点
                print(String.format("%d %d,%d %d ===",p1[0],p1[1],p2[0],p2[1]))
                for (k in j+1..points.lastIndex){
                    val p3 = points[k]
                    // 计算斜率会因为浮点数精度问题无法比较
                    // (p2[1]-p1[1])/(p2[0]-p1[0] )== (p3[1]-p2[1])/p3[0]-p2[0]
                    // 反正是看他俩等不等，可以对角相乘，计算乘积是否相等 数据范围在10000以内，也不会越界
                    if ((p2[0] - p1[0]) * (p3[1] - p2[1]) == (p2[1] - p1[1]) * (p3[0] - p2[0])) {
                        // 找到了
                        cnt++
                        print(String.format("%d %d,",p3[0],p3[1]))
                    }
                }
                println()
                if (cnt>max) max = cnt
            }
        }
        return max
    }
}