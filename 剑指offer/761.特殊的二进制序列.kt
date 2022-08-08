class Solution {
  fun makeLargestSpecial(s: String): String {
    // s 1和0数量相等。 任意长度的前缀中，1的数量大于0。
    // 转换为匹配括号问题更容易理解。（和）数量相等。总是先出现（ 才能出现）
    // 统计（ 和 ）的数量，相等的时候则可以匹配上，拨出外层2个，对内部排序，保留下排序过后的。继续向后遍历，将每一段能匹配上的都进行排序处理
    if (s.isEmpty()) return s
    var cnt = 0 // 记录括号数量
    var start = 1
    val l = mutableListOf<String>()
    for (i in 0 until s.length) {
      if (s[i] == '1') cnt++ else cnt--
      if (cnt == 0) {
        val sorted = '1' + makeLargestSpecial(s.substring(start, i)) + '0'
        l.add(sorted)
        start = i + 2 // i当前为是0，前缀任意长度的1都大叔0，所以i+1的位置一定是1，下一轮循环要截取的字串从i+2开始
      }
    }
    l.sortDescending()
    val sb = StringBuilder()
    for (sorted in l) {
      sb.append(sorted)
    }
    return sb.toString()
  }
}
