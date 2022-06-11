/** dp 方法一 */
//  fun minFlipsMonoIncr(s: String): Int {
//    // 前项是0 本项是0 改成1，次数+1；0不变，次数不变；
//    // 前项是0 本项是1 改成0，次数+1； 1不变，次数不变；
//    // 前项是1 本项是0 改成1，次数+1；
//    // 前项是1 本项是1 不变， 次数不变
//    val dp = Array(s.length) { IntArray(2) }
//    if (s[0] == '0') {
//      dp[0][0] = 0
//      dp[0][1] = 1
//    } else {
//      dp[0][1] = 0
//      dp[0][0] = 1
//    }
//    for (i in 1 until s.length) {
//      if (s[i] == '0') {
//        dp[i][0] = dp[i - 1][0] // 本项为0，必须前项为0，不用改
//        dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][1]) + 1 // 本项为1，改1，前项0 1都可以，次数+1
//      } else {
//        dp[i][0] = dp[i - 1][0] + 1 //本项为1，想改成0，必须前项为0,次数+1
//        dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][1]) //本项为1，前面是0是1都可以，次数不变
//      }
//    }
//    return minOf(dp.last()[0], dp.last()[1])
//  }

/** dp 后项只与前项一位有关系，可以用常量空间优化dp*/
fun minFlipsMonoIncr(s: String): Int {
  var preDp0 = 0 ;var preDp1 = 0;var dp0 = 0;var dp1 = 0
  for (i in s.indices) {
    if (s[i] == '0') {
      dp0 = preDp0
      // 本项为0，必须前项为0，不用改
      dp1 = minOf(preDp0,preDp1) + 1 // 本项为1，改1，前项0 1都可以，次数+1
    } else {
      dp0=preDp0 + 1 //本项为1，想改成0，必须前项为0,次数+1
      dp1 = minOf(preDp0,preDp1) //本项为1，前面是0是1都可以，次数不变
    }
    preDp0=dp0;preDp1=dp1
  }
  return minOf(preDp0,preDp1)
}