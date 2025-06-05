class Solution {
  val p = IntArray(26).apply { for (i in 0 until 26) this[i] = i }
  fun union(a: Int, b: Int) {
      val pa = find(a)
      val pb = find(b)

      if (pa < pb) p[pb] = pa
      else p[pa] = pb

  }

  fun find(x: Int): Int {
      if (p[x] != x) p[x] = find(p[x])
      return p[x]
  }

  fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
      // 将等价的一组，每组取最小的替换掉baseStr
      s1.zip(s2).forEach {
          union(it.first - 'a', it.second - 'a')
      }
      val ans = CharArray(baseStr.length)
      for (i in baseStr.indices) {
          ans[i] = 'a' + find(baseStr[i] - 'a')
      }
      return String(ans)
  }
}