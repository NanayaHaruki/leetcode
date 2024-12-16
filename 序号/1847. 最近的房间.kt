class Solution {
  fun closestRoom(_rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
      val rooms = _rooms.sortedWith { a, b -> a[1] - b[1] }
      val ans = IntArray(queries.size)
      queries.forEachIndexed { index, ints ->
          val (targetId, minSize) = ints
          var insertIndex = rooms.binarySearch(intArrayOf(0, minSize), { a, b -> if(a[1]==b[1]) a[0]-b[0] else a[1] - b[1] })
          if (insertIndex < 0) insertIndex = -insertIndex - 1 // 从insertIndex开始，后面size都是符合条件的
          // 接下来选id最近的
          var idDiff = Int.MAX_VALUE
          var ansId = -1
          for (i in insertIndex until rooms.size) {
              val (id,size) = rooms[i]
              val diff = abs(id-targetId)
              if (diff<idDiff || (diff==idDiff && id<ansId)){
                  idDiff=diff
                  ansId = id
              }
          }
          ans[index]=ansId
      }
      return ans
  }
}