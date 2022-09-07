class Solution() {
  fun reorderSpaces(text: String): String {
    // 数一下多少空格，数一下多少单词； 重新排列
    var spaceCnt = 0;
    var wordCnt = 0;
    val sb = StringBuilder()
    val q = mutableListOf<String>()
    for (i in text.indices) {
      val c = text[i]
      if (c == ' ') {
        spaceCnt++
        if (sb.isNotEmpty()) {
          wordCnt++
          q.add(sb.toString())
          sb.clear()
        }
      } else {
        sb.append(c)
      }
    }
    if (sb.isNotEmpty()) {
      wordCnt++
      q.add(sb.toString())
      sb.clear()
    }
    if(wordCnt==1){
      sb.append(q[0])
      repeat(spaceCnt){
        sb.append(' ')
      }
      return sb.toString()
    }
    repeat(spaceCnt / (wordCnt - 1)) {
      sb.append(' ')
    }
    val spaceBetween = sb.toString()
    sb.clear()
    repeat(spaceCnt % (wordCnt - 1)) {
      sb.append(' ')
    }
    val spaceLast = sb.toString()
    sb.clear()
    for (i in q.indices) {
      sb.append(q[i])
        .append(
          if (i == q.size - 1) spaceLast
          else spaceBetween
        )
    }
    return sb.toString()
  }
}