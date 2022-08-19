class Solution {
  fun movingCount(m: Int, n: Int, k: Int): Int {
    // m*n的格子里，数位之和不能大于k的格子数量 23，45 数位之和是2+3+4+5=14； mn-【0-100】 k【0，20】
    // 从0，0 出发，每个格子都从上方或左方过来
    fun sum(x: Int, y: Int): Int {
      var z = x;
      var ans = 0
      while (z > 0) {
        ans += z % 10
        z /= 10
      }
      z = y
      while (z > 0) {
        ans += z % 10
        z /= 10
      }
      return ans
    }
    
    val q = ArrayDeque<Int>()
    q.add(0) // 从0，0出发
    val s = mutableSetOf<Int>() // 用set保存可以经过的点，同时过滤相同的点
    val path = mutableSetOf<Int>() // 保存经过的点，走过了就不用再进队列
    while (q.isNotEmpty()) {
      val axis = q.removeFirst()
      val row = axis and 255 // m n 都是100以内，不超过8bit，用int的后8位表示行，前8位表示列
      val col = axis and 65280 shr 8// 255 就是0b 0000 0000 1111 1111 ，65280就是1111 1111 0000 0000
      if (sum(row, col) <= k) {
        s.add(axis)
        print("$row,$col ")
        var xy = row or ((col + 1) shl 8)
        if (col + 1 < n && !path.contains(xy)) {
          q.add(xy)
          path.add(xy)
        } // 不越界，就将下一步加进队列
        xy = (row + 1) or ((col shl 8))
        if (row + 1 < m && !path.contains(xy)) {
          q.add(xy)
          path.add(xy)
        }
      }
    }
    return s.size
  }
}