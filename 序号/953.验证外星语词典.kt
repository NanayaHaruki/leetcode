fun isAlienSorted(words: Array<String>, order: String): Boolean {
  // 验证是否words按字典序排列,将顺序存进map，保存索引，遍历word对比
  val dict = mutableMapOf<Char, Int>()
  for (c in order.indices) dict[order[c]] = c
  // 字典序，从0索引开始比对字符，前面比后面的小就满足，无关长度。
  // 当前面都相同，长度大的，排序在后
  for (i in 0..words.size - 2) {
    val minLen = minOf(words[i].length, words[i + 1].length)
    for (j in 0 until minLen) {
      // 从第一个字符比，只有前一个单词比后一个单词 该位置小，就通过，break比对下一组单词
      val charIndex = dict[words[i][j]]!!
      val nextCharIndex = dict[words[i + 1][j]]!!
      if (charIndex < nextCharIndex) break
      else if (charIndex > nextCharIndex) return false
      else {
        // 比完了,但前项还有字符
        if (j == minLen - 1 && minLen != words[i].length) return false
      }
    }
  }
  return true
}