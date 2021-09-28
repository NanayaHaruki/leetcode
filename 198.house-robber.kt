// 21-9-28
fun rob(nums: IntArray): Int {
    val n = nums.size
    val dp = Array(n) { IntArray(2) }
    // 第一维表示第几家  第二维表示偷不偷 ，值表示最大值
    dp[0][1]=nums[0]
    dp[0][0]=0
    for (i in 1 until n) {
        // 偷，上个没偷+当前的
        dp[i][1] = dp[i-1][0]+nums[i]
        // 不偷,从上家偷不偷的最大值里更新
        dp[i][0]= max(dp[i-1][0],dp[i-1][1])
    }
    return max(dp[n-1][0],dp[n-1][1])
}