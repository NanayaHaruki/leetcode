class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        // dp  每个点存的是包含这个点所能组成正方形的最大边长
        // 那么当点为0的时候，为0；当点为1的时候，值为 该点左边 上面 左上的最小值+1，因为必须3点都包含住，当前点才可能在这个正方形里
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m) { IntArray(n) }
        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = 1 + minOf(
                        dp.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0,
                        dp.getOrNull(i)?.getOrNull(j - 1) ?: 0,
                        dp.getOrNull(i - 1)?.getOrNull(j) ?: 0
                    )
                }
                ans = maxOf(ans, dp[i][j])
            }
        }
        return ans*ans
    }
}