import kotlin.math.*
class Solution {
    lateinit var nums: IntArray
    fun rob(nums: IntArray): Int {
        // 房子是她娘的环形，也就是第一家和最后一家只能偷一家
        // 那么遍历数组，传入区间范围，将第一家或最后一家择出去
        if (nums.size==1) return nums[0]
        this.nums = nums
        return max(dp(0, nums.size - 2), dp(1, nums.size - 1))
    }

    fun dp(start: Int, end: Int): Int {
        val n = nums.size
        val dp = Array(n) { IntArray(2) }
        dp[start][0] = 0
        dp[start][1] = nums[start]
        for (i in start + 1..end) {
            dp[i][1] = dp[i - 1][0] + nums[i]
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        }
        return max(dp[end][0], dp[end][1])
    }
}