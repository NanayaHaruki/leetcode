fun findSubstring(s: String, words: Array<String>): List<Int> {
  val sl = s.length;val wl = words[0].length;val wn = words.size
  val ans = mutableListOf<Int>()
  if (sl<wl*wn) return emptyList()
  // 长度相同的word，将s按照word的长度分成一段一段的，从words中匹配，能用光words，则该索引成立，跳到下个索引继续判断
  val d = mutableMapOf<String,Int>()
  
  for (i in 0 .. sl-wl*wn){
    d.clear()
    for (word in words) d[word]=(d[word]?:0)+1
    
    for (j in i until sl step wl) {
      val sub = s.substring(j, j + wl)
      val cnt = d[sub] ?: break
      if (cnt==1) d.remove(sub)
      else d[sub]=d[sub]!!-1
      if (d.isEmpty()) {
        ans.add(i)
        break
      }
    }
  }
  return ans
}