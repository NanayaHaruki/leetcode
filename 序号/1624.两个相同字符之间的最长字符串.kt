/** 两个相同字符之间的字符最长数量 */
//执行用时：152 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
//内存消耗：32.7 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
fun maxLengthBetweenEqualCharacters(s: String): Int {
  // 两个指针从首尾收束，记录字符的第一次出现的位置，有共同的字符出现，计算长度
  val d = mutableMapOf<Char,Int>()
  var ans = -1
  for (i in s.indices){
    val c = s[i]
    val idx = d[c]
    if (idx==null){
      d[c]=i
    }else {
      ans = maxOf(ans,i-1-idx)
    }
  }
  return ans
}





//执行用时：172 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
//内存消耗：32.8 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
fun maxLengthBetweenEqualCharacters(s: String): Int {
  // 两个指针从首尾收束，记录字符的第一次出现的位置，有共同的字符出现，计算长度
  val leftdict = mutableMapOf<Char,Int>()
  val rightDict = mutableMapOf<Char,Int>()
  val n = s.length
  for (i in s.indices){
    var idx = leftdict[s[i]]
    if (idx==null){
      leftdict[s[i]]=i
    }
    
    idx = rightDict[s[n-1-i]]
    if (idx==null){
      rightDict[s[n-1-i]]=n-1-i
    }
  }
  var ans = -1
  for ((c,i) in leftdict){
    val lastCharIndex = rightDict[c]
    if (lastCharIndex!=null){
      ans = maxOf(ans,lastCharIndex-i-1)
    }
  }
  return ans
}