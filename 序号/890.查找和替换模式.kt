fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
  // 选出符合pattern的单词
  // 字典记录对应关系，遇到char，字典不存在就插入，存在就对比
  val n = pattern.length - 1;
  val d = mutableMapOf<Char, Char>();
  val l = mutableListOf<String>();
  val s = mutableSetOf<Char>()
  var a: Char;
  var b: Char
  for (word in words) {
    var fit = true
    for (i in 0..n) {
      a = word[i];b = pattern[i]
      val c = d[b]
      if (s.add(a) && c==null) {
        d[b] = a
      } else {
        if (c == a) continue
        else {
          fit = false
          break
        }
      }
    }
    d.clear()
    s.clear()
    if (fit) l.add(word)
  }
  return l
}