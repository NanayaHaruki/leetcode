class Solution {
    fun checkRecord(n: Int): Int {
        val mod = 1000_000_007
        // n表示考勤天数，即ALP组成的字符串长度，
        // 可以拿到出勤奖的数量由总天数、A的次数、L次数构成，dp为3维
        val dp = Array(n + 1) {
            // A的次数 只能0和1
            Array(2) {
                // L的次数可以0 1 2
                IntArray(3)
            }
        }
        dp[0][0][0] = 1
        // 状态转移方程

        // 当前是P 那么A不变，L归0
        // dp[i][j][0] = dp[i-1][j][0]+dp[i-1][j][1]+dp[i-1][j][2]

        // 当前是A ,那么之前的A只能是0,如果是1，加上这次就是2,拿不到奖了，L 归0
        // dp[i][j][k]=dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]

        // 当前是L
        // dp[i][j][k]+=dp[i-1][j][k-1]

        // dp[1][1][2] 由dp[1][0][2]+dp[1][1][1]
        for (i in 1..n) {
            for (j in 0..1) {
                // 当前是P
                for (k in 0..2) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % mod
                }
            }
            // 当前是A
            for (k in 0..2) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % mod
            }
            // 当前是L
            for (j in 0..1) {
                for (k in 1..2) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod
                }
            }
        }
        var ans = 0
        for (j in 0..1) {
            for (k in 0..2) {
                ans = (ans + dp[n][j][k]) % mod
            }
        }
        return ans
    }
}