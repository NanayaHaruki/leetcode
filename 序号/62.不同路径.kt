// 方法一 DP，其实就是斐波那契数列
fun uniquePaths(m: Int, n: Int): Int {
    // 从00 走到 mn ，每个点的走法，只能是从左边过来或从上面过来
    val dp = Array(m) { row -> IntArray(n) { col -> if (row == 0 || col == 0) 1 else 0 } }
    for (i in 1 until m) {
        for (j in 1 until n) {
            // 第一行，只能从左边过来
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]

        }
    }
    return dp[m - 1][n - 1]
}

// 方法二 排列组合
fun uniquePaths(m: Int, n: Int): Int {
    // 总步数为 m+n-2,在走这么多步的路线中，正确的路线为横向走了m-1或纵向走了n-1的
    // 用组合公式C(m+n-2)(m-1)
    val min = min(m, n)
    var result = 1L
    for (i in 1..min - 1) {
        val x = m + n - 2 - (i - 1)
        result *=x
        result/=i
    }
    return result.toInt()
}