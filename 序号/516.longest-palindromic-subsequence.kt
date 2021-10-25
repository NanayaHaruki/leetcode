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
}