class Solution {
  fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
      val n = floor.length
      val ps = IntArray(n + 1) // 前缀和查询任意区间有多少个1
      floor.forEachIndexed { index, c ->
          ps[index + 1] = ps[index]+(c-'0')
      }
      val dp = Array(numCarpets+1) { IntArray(n + 1) } // dp[i][j] 用i条地毯能覆盖[0,j]最多多少白色1
      for (i in 1..numCarpets) {
          val k = i*carpetLen
          if(k<=n) dp[i][k]=ps[k]
          else return 0 // i个地毯都超过总长度了，那可以全覆盖，1个不剩
          for (j in i*carpetLen .. n) {
              dp[i][j]= max(dp[i][j],dp[i][j - 1]) // 不用地毯
              dp[i][j]= max(dp[i][j],dp[i - 1][j - carpetLen] + ps[j] - ps[j - carpetLen] )// 用一块毯子覆盖最后的部分
          }
      }
      return ps[n]-dp.last().last()
  }
}