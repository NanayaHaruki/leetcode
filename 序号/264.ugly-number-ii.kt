class Solution {
    val dp = IntArray(1691)
    fun nthUglyNumber(n: Int): Int {
        if (dp[n]!=0)return dp[n]
        // 质因数2 3 5,找第n个丑数
        // 用dp存，dp[n]为答案
        dp[1] = 1
        var p1 = 1
        var p2 = 1
        var p3 = 1
        for (i in 2..n) {
            val n1 = dp[p1] * 2
            val n2 = dp[p2] * 3
            val n3 = dp[p3] * 5
            val num = minOf(n1, n2, n3)
            if (n1 == num) p1++ //丧失与2乘的资格，指针自增
            if (n2 == num) p2++
            if (n3 == num) p3++
            dp[i] = num
        }
        return dp[n]
    }
}