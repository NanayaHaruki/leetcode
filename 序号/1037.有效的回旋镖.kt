class Solution {
  fun isBoomerang(points: Array<IntArray>): Boolean {
    // 三点不共线返回true
    // 两点确定一条直线，用第三点算斜率就行，因为浮点数有精度问题，用乘法计算
    val dx1 = points[0][0]-points[1][0]
    val dy1 = points[0][1]-points[1][1]
    val dx2 = points[1][0]-points[2][0]
    val dy2 = points[1][1]-points[2][1]
    if ((dx1==0 && dy1==0) || (dx2==0 && dy2==0)) return false // 共点
    return dx1*dy2!=dx2*dy1
  }
}