class Solution {
  fun shortestToChar(s: String, c: Char): IntArray {
    // c为s中出现的字符 返回数组表示每个索引处字符与最近的c的距离
    // 考虑快慢指针，快指针找前面的c的位置，慢指针计算距离填充答案
    var left = -1
    var right = s.indexOfFirst { it == c }
    val ans = IntArray(s.length)
    for (i in s.indices) {
      if (i < right) {
        if (left < 0) ans[i] = right - i
        else if (right >= s.length) ans[i] = i - left
        else ans[i] = minOf(i - left, right - i)
      } else {
        ans[i] = 0
        var tmp = right + 1
        while (tmp < s.length && s[tmp] != c) {
          tmp++
        }
        right = tmp
        left = i
      }
    }
    return ans
  }
}