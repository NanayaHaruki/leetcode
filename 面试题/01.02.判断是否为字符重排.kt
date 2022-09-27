fun CheckPermutation(s1: String, s2: String): Boolean {
  val c1 = IntArray(128)
  val c2 = IntArray(128)
  if (s1.length!=s2.length) return false
  val n = s1.length
  for (i in 0 until n){
    c1[s1[i].code]++
    c2[s2[i].code]++
  }
  for (i in c1.indices){
    if (c1[i]!=c2[i])
      return false
  }
  return true
}