fun numberOfLines(widths: IntArray, s: String): IntArray {
  // widths 每个字母占用多长 返回占用几行，最后一行占用多少 ，每行长度100
  var line = 1
  var curLineLength = 0
  for (i in s.indices){
    val curCharLength = widths[s[i]-'a']
    if (curLineLength + curCharLength > 100) {
      // 这行放不下，丢下一行
      curLineLength=curCharLength
      line++
    }else{
      // 放得下
      curLineLength+=curCharLength
    }
  }
  return intArrayOf(line,curLineLength)
}