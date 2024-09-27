class Solution {
  fun check(len: Int, cs: CharArray, limit: IntArray): Boolean {
    var cnts = IntArray(3)
    for (i in 0 until len) {
      cnts[cs[i] - 'a']++
    }
    var ret = true
    for (j in 0..2) {
      if (cnts[j] > limit[j]) ret = false
    }
    if (ret) return true
    for (i in 1 .. cs.size - len) {
      val preChar = cs[i - 1]
      val newChar = cs[i + len - 1]
      cnts[preChar - 'a']--
      cnts[newChar - 'a']++
      ret = true
      for (j in 0..2) {
        if (cnts[j] > limit[j]) ret = false
      }
      if (ret) return true
    }
    return false
  }

  fun takeCharacters(s: String, k: Int): Int {
    var a = 0
    var b = 0
    var c = 0
    for (x in s) {
      when (x) {
        'a' -> a++
        'b' -> b++
        else -> c++
      }
    }
    if (a < k || b < k || c < k) return -1
    val limit = intArrayOf(a - k, b - k, c - k)
    val cs = s.toCharArray()
    var l = 0
    var r = s.length+1
    while (l + 1 < r) {
      val m = (l + r) / 2
      if (check(m, cs, limit)) {
        l = m
      } else {
        r = m
      }
    }
    return s.length - l
  }
}