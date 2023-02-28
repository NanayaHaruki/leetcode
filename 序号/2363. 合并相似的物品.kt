class Solution {
  fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    val d = TreeMap<Int, Int>()
    for (i in items1) d[i[0]] = d.getOrDefault(i[0], 0) + i[1]
    for (i in items2) d[i[0]] = d.getOrDefault(i[0], 0) + i[1]
    for ((k, v) in d) ans.add(listOf(k, v))
    return ans
  }
}