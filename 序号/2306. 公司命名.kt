class Solution {
  fun distinctNames(ideas: Array<String>): Long {
    val d = mutableMapOf<String, Int>()
    val firstLetters = mutableSetOf<Char>()
    val v = setOf(*ideas)
    for (x in ideas) firstLetters.add(x[0])
    var ans = 0L
    for (x in ideas) {
      for (f in firstLetters) {
        if (!v.contains(f + x.substring(1))) {
          val key = x[0].toString()+f
          val reverseKey = key.reversed()
          ans += d.getOrDefault(key, 0)
          d[reverseKey]= d.getOrDefault(reverseKey, 0) + 1
        }
      }
    }
    return ans * 2
  }
}