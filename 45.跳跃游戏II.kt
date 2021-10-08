import kotlin.math.min

class Solution {
    fun jump(nums: IntArray): Int {
        // 动规，用dp存储到每个位置所需要的最小步数，答案就是dp[n]
        // basecase
        val n = nums.size
        val dp = IntArray(n)
        dp[0] = 0 //起始点，不用跳

        // 转移方程  遍历到n的时候，更新dp索引为[n+1,n+nums[n]]的数据
        // 为0的更新为 dp[n]+1，不为0的不用更新，肯定是更前面就能跳到的位置
        for (i in 0 until n) {
            val step = nums[i]
            val start = i + 1
            var end = i + step
            end = min(end, n - 1)
            for (j in start..end) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1
                }
            }
        }
        return dp[n - 1]
    }
}