import kotlin.math.max

fun main() {
}


class Solution {
    fun canPartition(nums: IntArray): Boolean {
        var sum = nums.sum()
        if (sum%2!=0) return false
        sum /=2
        // dp[i][j] 前面i个数，和为j的可能性
        val dp = Array(nums.size+1){BooleanArray(sum+1)}
        // basecase 不管前面几个数，不装就是0，可能性存在
        for (i in dp.indices){
            dp[i][0]=true
        }
        // 转移方程 dp[i][j]=dp[i-1][j] | dp[i-1][j-nums[i-1]
        for (i in 1..nums.size){
            for(j in 0..sum){
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]
                }else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[nums.size][sum]
    }
}

