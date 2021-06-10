class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        // 定义：dp[i] 为总金额为i时的方案数
        // 转移：dp[i] += dp[i-j]
        // basecase dp[0] = 1
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (i in coin..amount) {
                dp[i]+=dp[i-coin]
            }
        }
        return dp[amount]
    }
}