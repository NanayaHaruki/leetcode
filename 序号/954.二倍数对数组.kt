import kotlin.math.abs
class Solution {
  fun canReorderDoubled(arr: IntArray): Boolean {
    val dict = mutableMapOf<Int, Int>()
    arr.forEach { dict[it] = dict.getOrDefault(it, 0) + 1 }
    val list = dict.keys.toList().sortedWith(object : Comparator<Int> {
      override fun compare(a: Int, b: Int): Int {
        return abs(a)-abs(b)
      }
    })
    list.forEach {
      if (dict.getOrDefault(it * 2, 0) < dict.getOrDefault(it, 0)) return false
      dict[it * 2] = dict.getOrDefault(it * 2, 0) - dict.getOrDefault(it, 0)
    }
    return true
  }
}