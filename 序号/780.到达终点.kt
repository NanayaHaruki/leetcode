class Solution {
  fun reachingPoints(_sx: Int, _sy: Int, _tx: Int, _ty: Int): Boolean {
    var (a, b, c, d) = intArrayOf(_sx, _sy, _tx, _ty)
    // 反向相减
    while (a < c && b < d) {
      if (c > d) c %= d
      else d %= c
    }
    if (c < a || d < b) return false
    return if (a == c) {
      (d - b) % c == 0
    } else {
      (c - a) % d == 0
    }
  }
}