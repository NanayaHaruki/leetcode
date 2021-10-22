import kotlin.math.*
fun minCostClimbingStairs(cost: IntArray): Int {
    // dp[n] 表示到n的时候，需要的最小cost
    val dp = IntArray(cost.size + 1)
    // 可以选择从0 或 1开始，那么这2层不需要消耗
    dp[0] = 0
    dp[1] = 0
    for (i in 2..cost.size) {
        val pre1Cost = cost[i - 1]
        val pre2Cost = cost[i - 2]
        dp[i] = min(dp[i - 1] + pre1Cost, dp[i - 2] + pre2Cost)
    }
    return dp.last()
}