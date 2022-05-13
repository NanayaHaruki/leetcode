import kotlin.math.abs
class Solution {
  fun oneEditAway(first: String, second: String): Boolean {
    // 是否能只改一个字符
    val na = first.length
    val nb = second.length
    if (abs(na-nb)>1) return false
    var isChange = false
    var (pa, pb) = 0 to 0
    while (pa < na && pb < nb) {
      if (first[pa] != second[pb]) {
        if (isChange) return false
        if (na == nb) {
          // 长度相同，只能交换
          isChange = true
          pa++
          pb++
        } else {
          // 长度不同，短的+1
          if (na < nb) pb++ else pa++
          isChange = true
        }
      }else{
        pa++
        pb++
      }
    }
    return true
  }
}