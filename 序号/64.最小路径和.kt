class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        // 找从左上到右下总和最小
        val row = grid.size
        val col = grid.first().size
        val dp = Array(row) { IntArray(col) }
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j]
                else
                    dp[i][j] = minOf(dp.getOrNull(i - 1)?.getOrNull(j) ?: Int.MAX_VALUE,
                        dp.getOrNull(i)?.getOrNull(j - 1) ?: Int.MAX_VALUE) + grid[i][j]
            }
        }
        return dp[row - 1][col - 1]
    }
}