/**
 时间504 ms击败100%内存127.6 MB击败50%
 */
// class Solution {
//   val q = mutableListOf<Int>()
//   var n = 0
//   val path = mutableSetOf<Int>()
//   fun dfs(x: Int): Boolean {
//     if (path.size == 1 shl n) {
//       val j = q[0] xor x
//       if (j != 0 && (j and (j - 1)) == 0) {
//         return true
//       }
//       return true
//     }
//     for (i in 0 until n) {
//       val newX = x xor (1 shl i)
//       if (!path.contains(newX)) {
//         q.add(newX)
//         path.add(newX)
//         val res = dfs(newX)
//         if (res) {
//           return true
//         } else {
//           q.removeAt(q.lastIndex)
//           path.remove(newX)
//         }
//       }
//     }
//     return false
//   }

//   fun circularPermutation(_n: Int, start: Int): List<Int> {
//     n = _n
//     // n 意味着有多少位二进制 相邻的数只有一位不同 首末位只有一位不同
//     q.add(start)
//     path.add(start)
//     dfs(start)
//     return q
//   }
// }

class Solution {

  fun circularPermutation(_n: Int, start: Int): List<Int> {
    val q = mutableListOf<Int>()
    val sz = 1 shl _n
    for(i in 0 until sz){
      q.add(i xor (i shr 1) xor start)
    }
    return q
  }
}