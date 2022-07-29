class Solution {
  fun distance(a: IntArray, b: IntArray) =
    (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])
  
  fun check(ps: Array<IntArray>): Boolean {
    val ds = IntArray(3) // 保存当前验证的点，与其他3个点的距离
    var k = 0
    for (i in 0..3) {
      for (j in 0..3) {
        if (i == j) continue
        ds[k++] = distance(ps[i], ps[j])
      }
      k = 0
      if (ds[0] == ds[1] && ds[2] == ds[0] * 2) continue
      if (ds[0] == ds[2] && ds[1] == ds[0] * 2) continue
      if (ds[1] == ds[2] && ds[0] == ds[1] * 2) continue
      return false
    }
    return true
  }
  
  fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
    // 计算其他三个点与第1个点的距离，如果是正方形则有2个点的距离相同，另一个点的距离是这个距离的根号2倍
    
    // 排除共线，不需要计算是否垂直，后面计算边长就可以证明垂直
    // 计算斜率有浮点精度问题，用对角相乘代替
    if (
      ((p1[1] - p2[1]) * (p1[0] - p3[0]) == (p1[1] - p3[1]) * (p1[0] - p2[0]))
      || ((p1[1] - p2[1]) * (p1[0] - p4[0]) == (p1[1] - p4[1]) * (p1[0] - p2[0]))
      || ((p1[1] - p3[1]) * (p1[0] - p4[0]) == (p1[1] - p4[1]) * (p1[0] - p3[0]))
    ) {
      return false
    }
    return check(arrayOf(p1, p2, p3, p4))
  }
}