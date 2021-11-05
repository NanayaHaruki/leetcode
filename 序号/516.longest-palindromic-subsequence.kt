class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        // 不连续的最长回文子序列
        // 反转一波，最长回文子序列问题 转化为 求最长公共子序列
        val n = s.length
        val dp = Array(n+1){IntArray(n+1)}
        val charArr = s.toCharArray()
        val reserveCharArr = CharArray(n)
        for (i in charArr.indices) reserveCharArr[n-i-1]=charArr[i]
        for (i in 1 .. n){
            for (j in 1 .. n){
                if (charArr[i-1] == reserveCharArr[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1
                }else {
                    dp[i][j]= max(dp[i-1][j],dp[i][j-1])
                }
            }
        }
        return dp[n][n]
    }

    fun longestPalindromeSubseq(s: String): Int {
        // 回文子序列，从短的字符向长的转移
        // dp[i][j]表示从i到j的最长回文子序列长度
        val n = s.length
        val arr = s.toCharArray()
        val dp = Array(n) { IntArray(n) }
        for (len in 1..n) {
            for (l in 0 until n) {
                val r = l + len - 1
                if (r >= n) break
                dp[l][r] = when (len) {
                    1 -> 1
                    2 -> if (arr[l] == arr[r]) 2 else 1
                    else -> if (arr[l] == arr[r]) dp[l + 1][r - 1] + 2 else maxOf(dp[l + 1][r], dp[l][r - 1])
                }
            }
        }
        return dp[0][n-1]
    }
}