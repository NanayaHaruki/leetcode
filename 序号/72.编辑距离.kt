class Solution {
    fun minDistance(word1: String, word2: String): Int {
        // 可以插入，可以替换
        val m = word1.length
        val n = word2.length
        // dp[i][j]定义为 word1前i个字符 转化为word2前j个字符需要的步骤数
        val dp = Array(m + 1) { IntArray(n + 1) }
        // 需要预留删到空串的情况
        for (i in 0 .. m) dp[i][0] = i
        for (i in 0 .. n) dp[0][i] = i
        for (i in 1 .. m) {
            for (j in 1 .. n) {
                if (word1[i - 1] == word2[j - 1]) {
                    // 字符相同，不需要处理，步骤数等于前面的
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    // 字符数不同，最小步骤为删掉一个,由m-1,n 或m,n-1转移到mn，为增加或删除，m-1,n-1转移为替换一个字符
                    dp[i][j] = 1 + minOf(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])
                }

            }
        }
        return dp[m][n]
    }
}