import kotlin.math.min
class Solution {
  fun minCost(costs: Array<IntArray>): Int {
    // 将costs.size 个房子刷成3种颜色的cost为costs[0][0-3],求最小cost
    // 第n个房子的cost只与上一个有关，压缩dp
    var preR = 0;var preG = 0;var preB = 0 // 上一个房子选择3种颜色的最小值
    for(arr in costs){
      val curR = min(preG,preB)+arr[0]
      val curG = min(preR,preB)+arr[1]
      val curB = min(preR,preG)+arr[2]
      preR = curR;preG=curG;preB=curB
    }
    return minOf(preR,preB,preG)
  }
}