class Solution {
    fun lastStoneWeightII(stones: IntArray): Int {
        // 要想结果最小，得找到两堆重量相近的
        val sum = stones.sum()
        val target = sum/2
        val n = stones.size
        val dp = Array(n + 1) { BooleanArray(target+1) }
        // 定义dp[i][j]为利用前面i个石头，可以组合出j的可能性
        // basecase
        dp[0][0] = true
        for (i in 1..n) {
            for (j in 0..target) { //石头最大就是100 怎么撞只能小于100
                val preWeight = stones[i - 1]
                dp[i][j] = dp[i-1][j]
                if (j>=preWeight)
                    dp[i][j] = dp[i][j] or dp[i-1][j-preWeight]
            }
        }
        for (i in dp[n].lastIndex downTo 0) {
            if (dp[n][i]) return sum-i-i
        }
        return 0
    }
}