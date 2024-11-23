class Solution {
  fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
    val d = Array(n){mutableMapOf<Int,Int>()}
    pick.forEach{ (playerId,color)->
      d[playerId][color] = d[playerId].getOrDefault(color,0)+1
    }
    var cnt = 0
    d.forEachIndexed{playerId,mp->
      if((mp.values.maxOrNull()?:0)>playerId) cnt++
    }
    return cnt
  }
}