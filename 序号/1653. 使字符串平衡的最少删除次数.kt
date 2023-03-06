class Solution {
  fun minimumDeletions(s: String): Int {
    // b 后面不能有a，遍历每个划分点，该点前面不能有b，后面不能有a
    val cs = s.toCharArray()
    var a = 0
    for (c in cs) {
      if (c == 'a') a++
    }
    var ans = a // 初始化为删掉全部后面a
    var b = 0
    for (c in cs) {
      if (c == 'b') {
        b++
      } else {
        a--
      }
      ans = minOf(ans, a + b)
    }
    return ans
  }
}