class Solution {
  fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val d = mutableMapOf<Int, MutableList<Int>>()
    for (i in groupSizes.indices) {
      var persons = d[groupSizes[i]]
      if (persons == null) persons = mutableListOf()
      persons!!.add(i)
      d[groupSizes[i]] = persons
    }
    val ans = mutableListOf<MutableList<Int>>()
    for ((k, v) in d) {
      var tmpList: MutableList<Int>? = null
      for (i in v.indices) {
        if (i % k == 0) tmpList = mutableListOf()
        tmpList!!.add(v[i])
        if (i % k == k-1) ans.add(tmpList!!)
      }
    }
    return ans
  }
}