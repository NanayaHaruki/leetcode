fun findLUSlength(strs: Array<String>): Int {
  // 最长特殊子序列长度；特殊子序列为不是其他字符串的子序列，子序列含有别的字符串没有的字符才会是特殊子序列，所以最长的特殊子序列就是含有特殊字符的最长的字符串
  var ans = -1
  val n = strs.size
  for (i in 0 until n) {
    // 全都不是子序列i才满足条件
    var fit = true
    for (j in 0 until n) {
      if(i==j) continue
      if (isSub(strs[i], strs[j])) {
        fit = false
        break
      }
    }
    if (fit) ans = maxOf(ans, strs[i].length)
  }
  return ans
}

/** 判断a是否为b的子序列 */
fun isSub(a: String, b: String): Boolean {
  if (a.length > b.length) return false
  var ai = 0;
  var bi = 0;
  while (ai < a.length && bi < b.length) {
    if (a[ai] == b[bi]) {
      ai++;bi++
    } else {
      bi++
    }
  }
  return ai == a.length //a的索引走到最后了，说明是子序列
}