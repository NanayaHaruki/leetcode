class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val size = longestCommonSubsequence(word1,word2)
        return word1.length+word2.length-size*2
    }
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val arr1 = text1.toCharArray()
        val arr2 = text2.toCharArray()
        // dp[i][j] 表示 text1[0..i-1] 与 text2[0..j-1]的公共子序列长度
        val dp = Array(arr1.size+1){IntArray(arr2.size+1)}
        // 当i和j为0时，dp[i][j]=0
        for (i in 1 .. arr1.size) {
            for (j in 1 .. arr2.size){
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j]=1+dp[i-1][j-1]
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])
                }
            }
        }
        return dp[arr1.size][arr2.size]
    }

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        // LCS
        val m = text1.length
        val n = text2.length
        // dp[i][j] 记录text1中[0,i]范围内和text2[0,j]范围的最长公共子序列长度
        val dp = Array(m){ IntArray(n)}
        for (i in 0 until m){
            for (j in 0 until n) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = (dp.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0) + 1
                } else {
                    dp[i][j] = maxOf(dp.getOrNull(i - 1)?.getOrNull(j) ?: 0, dp.getOrNull(i)?.getOrNull(j - 1) ?: 0)

                }
            }
        }
        return dp[m-1][n-1]
    }
}