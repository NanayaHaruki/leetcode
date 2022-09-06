class Solution {
  fun uniqueLetterString(s: String): Int {
    // 遍历所有字符，统计包含这个字符的子串个数即可
    val m = mutableMapOf<Char,MutableList<Int>>() // 统计每个字符出现的索引
    // 包含ci字符的子串个数为 (ci-cj)*(ck-ci)
    for (i in s.indices){
      val c = s[i]
      val l = m.getOrDefault(c, mutableListOf(-1))
      l.add(i)
      m[c]=l
    }
    // 统计完了，开始计算
    var ans = 0
    for ((k,v) in m){
      v.add(s.length)
      for (i in 1 until v.size-1){
        ans+=(v[i]-v[i-1])*(v[i+1]-v[i])
      }
    }
    return ans
  }
  
  /* TLE
  fun uniqueLetterString(s: String): Int {
    // 所有字串中唯一字符的个数
    // 定义dp[i] 为包含i的所有字串中出现的唯一字符数量
    var cur = 0
    for (i in 0 until s.length) {
      cur += countUniqueCharCount(s, i)
    }
    return cur
  }
  
  /** 返回包含lastIndex的s的字串中唯一字符的个数 */
  fun countUniqueCharCount(s: String, lastIndex: Int): Int {
    var ans = 0
    for (i in 0..lastIndex) {
      val cnts = IntArray(26)
      for (j in i..lastIndex) {
        cnts[s[j] - 'A']++
      }
      for (cnt in cnts) {
        if (cnt == 1) ans++
      }
    }
    return ans
  }
  
   */
}