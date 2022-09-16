class Solution {
  fun rectangleArea(rectangles: Array<IntArray>): Int {
    // 现将所有矩形根据左边界排序,统计每个左边界，有哪些高度差。当边界相同时，计算高度差。 不交叉，直接求和。交叉则去掉交叉部分
    // 扫描线，将每个矩形边界排序，扫描每个纵向边界区间，将对这段x轴区间有贡献的矩形高度拿出来，判断高度的交叉
    
    // 创建扫描线
    val x_edges = TreeSet<Int>()
    for ((l, _, r, _) in rectangles) {
      x_edges.add(l);x_edges.add(r);
    }
    
    var ans = 0L
    val mod = (1e9 + 7).toInt()
    val it = x_edges.iterator()
    var l = it.next();
    var r: Int
    while (it.hasNext()) {
      // 确定区间
      r = it.next()
      // 在区间内找有贡献度的矩形，将高度拿出来
      val y_list = mutableListOf<IntArray>()
      for (rect in rectangles) {
        if (rect[0] <= l && rect[2] >= r) y_list.add(intArrayOf(rect[1], rect[3]))
      }
      if (y_list.isNotEmpty()) {
        y_list.sortWith(Comparator<IntArray> { o1, o2 -> if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0] })
        var sumDiffY = y_list[0][1] - y_list[0][0];
        var preHigh = y_list[0][1]
        for (i in 1 until y_list.size) {
          val low = y_list[i][0];
          val high = y_list[i][1]
          // 不交叉
          if (low > preHigh) {
            sumDiffY += (high - low)
            preHigh = high
          } else if(high>preHigh) {
            // 有交叉，直接延长
            sumDiffY += (high - preHigh)
            preHigh = high
          }
        }
        ans += (r - l).toLong() * sumDiffY
        ans %= mod
      }
      l = r
    }
    return ans.toInt()
  }
}