class Solution {
    /**
     * @param n 人数
     * @param minProfit 最小利润
     * @param group 每个任务所需人数
     * @param profit 每个任务利润
     * @return 方案数
     * */
    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val mod = 1000000007
        // dp[i][j][k] i个任务 用了j个人 获得最小利润为k的方案数
        val dp = Array(profit.size + 1) { Array(n + 1) { IntArray(minProfit + 1) { 0 } } }
        // basecase 0个任务 多少人来 利润都是0,就这一种方案
        for (i in 0..n) {
            dp[0][i][0] = 1
        }
        for (i in 1..profit.size) {
            val profitUnit = profit[i - 1]
            val amount = group[i - 1]
            for (j in 0..n) {
                for (k in 0..minProfit) {
                    // 这个活不干了  方案数等于 上个任务同等人数方案数
                    dp[i][j][k] = dp[i - 1][j][k]
                    // 人不够自然是0,不用赋值，用人的情况
                    if (j >= amount) {
                        // += 使用了差值的人数获得差值利润的方案数    利润为负的统一归到0利润的方案数上去
                        dp[i][j][k] += dp[i - 1][j - amount][(k - profitUnit).let { if (it < 0) 0 else it }]
                        dp[i][j][k] %= mod
                    }
                }
            }
        }
        return dp[group.size][n][minProfit]
    }
}