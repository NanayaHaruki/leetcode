class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        // 求最小删除ascii和，就是LCS求最长子串的逻辑，改为过程中找ascii最大
        val arr1 = s1.toCharArray()
        val arr2 = s2.toCharArray()
        val dp = Array(arr1.size + 1) { IntArray(arr2.size + 1) }
        for (i in 1..arr1.size) {
            for (j in 1..arr2.size) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + arr1[i - 1].toInt()
                } else {
                    dp[i][j] = if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i - 1][j]
                    } else {
                        dp[i][j - 1]
                    }
                }
            }
        }
        return arr1.sumBy { it.toInt() } + arr2.sumBy { it.toInt() } - dp[arr1.size][arr2.size] * 2
    }
}