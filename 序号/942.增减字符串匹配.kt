fun diStringMatch(s: String): IntArray {
  //  ans[i]>ans[i+1] s[i]=='D' else 'I'
  //  双指针，大的就从大的拿，小的就从小的拿
  val ans = IntArray(s.length + 1)
  var l = 0
  var r = s.length
  for (i in s.indices) {
    if (s[i] == 'I') {
      ans[i] = l++
    } else {
      ans[i] = r--
    }
  }
  ans[s.length] =if (s.last() == 'I') r else l
  return ans
}