fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
  // 记录下行和列被操作的次数
  // 某行为偶，则列被操作数为奇数，则这一行上有多少个奇数
  // 某行为奇，则找列数操作数为偶数的
  val row = IntArray(m)
  val col = IntArray(n)
  for (p in indices) {
    row[p[0]]++;col[p[1]]++
  }
  var oddRow = 0;
  var oddCol = 0
  for (i in row) {
    if (i % 2 == 1) oddRow++
  }
  for (i in col) {
    if ((i % 2 == 1)) oddCol++
  }
  var ans = 0
  for (i in 0 until m) {
    ans += if (row[i] % 2 == 0) oddCol
    else n - oddCol
  }
  return ans
}