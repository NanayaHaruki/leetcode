const val push="Push"
const val pop="Pop"
class Solution {
  fun buildArray(target: IntArray, n: Int): List<String> {
    var cur = 1
    val ans = mutableListOf<String>()
    for (i in target){
      while (i!=cur) {
        ans.add(push)
        ans.add(pop)
        cur++
      }
      ans.add(push)
      cur++
    }
    return ans
  }
}