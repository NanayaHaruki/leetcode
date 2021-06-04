import kotlin.math.max

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        //dp[i]表示最长自序列的长度，最小肯定就自己一个，长度为1
        // 当前的最长长度为 前面的比我小的数中，找到最长的那个max， 当前值就是max+1
        val dp = IntArray(nums.size) { 1 }
        var max = 1
        for (i in nums.indices) {
            var subMax = 1
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    subMax = max(subMax, nums[j])
                }
            }
            dp[i] = subMax + 1
            max = max(max, dp[i])
        }
        return max
    }
}