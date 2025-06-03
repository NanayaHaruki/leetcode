class Solution {
  fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
      val q = ArrayDeque<Int>() // 有钥匙待开的盒子
      val n = status.size
      val ownBoxes = mutableSetOf<Int>(*(initialBoxes.toTypedArray())) // 拥有的盒子
      val ownKeys = mutableSetOf<Int>()
      val vis = BooleanArray(n)
      for(b in initialBoxes){
          if(status[b]==1) {
              q.add(b)
              vis[b]=true
          }
      }


      var ans = 0
      while(q.isNotEmpty()){
          val sz = q.size
          for(i in 0 until sz) {
              val curBox = q.removeFirst()
              ownBoxes.remove(curBox)
              ans += candies[curBox]
              ownKeys.addAll(keys[curBox].toList())
              ownBoxes.addAll(containedBoxes[curBox].toList())
          }
          for (b in ownBoxes) {
              if (!vis[b] && status[b] == 1 || ownKeys.contains(b)) {
                  q.add(b)
                  vis[b]=true
              }
          }
      }
      return ans
  }
}