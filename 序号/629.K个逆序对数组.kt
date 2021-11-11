class Solution {
    val mod = 1000_000_000 + 7
    fun kInversePairs(n: Int, k: Int): Int {
        // 索引小，但值大的可能性
        // 1234  多0种 dp[i+1][j]=dp[i][j] => dp[i][j]=dp[i-1][j]
        // 1243  多1个 dp[i+1][j+1]=dp[i][j]=>dp[i][j]=dp[i-1][j-1]
        // 1423 多2个  dp[i+1][j+2]=dp[i][j]=>dp[i][j]=dp[i-1][j-2]
        // 4123 多3个 dp[i+1][j+3]=dp[i][j]=>dp[i][j]=dp[i-1][j-i+1] //注意j-i+1可能为负
        // dp[i][j]   =dp[i-1][j]+dp[i-1][j-1]+...+dp[i-1][j-(i-2)]+dp[i-1][j-(i-1)]
        // dp[i][j-1] =           dp[i-1][j-1]+...                 +dp[i-1][j-(i-1)]+dp[i-1][j-i]
        // dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]


        val dp = Array(n + 1) { IntArray(k + 1) }
        dp[1][0] = 1
        for (i in 2..n) {
            for (j in 0..k) {
                if (j == 0) dp[i][j] = dp[i - 1][j]
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - if (j >= i) dp[i - 1][j - i] else 0)
                if (dp[i][j] >= mod) dp[i][j] -= mod
                if (dp[i][j] < 0) dp[i][j] += mod
            }

        }
        return dp[n][k]
    }
}