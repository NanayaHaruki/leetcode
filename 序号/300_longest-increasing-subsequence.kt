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

    // fun lengthOfLIS(nums: IntArray): Int {
    //     if (nums.size==1) return 1
    //     // 动态规划  每次找到前面小于当次遍历的数， 找到前面最长子序列 加1，遍历完
    //     val dp = IntArray(nums.size)
    //     dp[0] = 1
    //     var longest = 0
    //     var ans = 1
    //     for (i in 1 until nums.size) {
    //         for (j in 0 until i){
    //             if (nums[j] < nums[i] && dp[j]>longest) {
    //                 longest = dp[j]
    //             }
    //         }
    //         val newLongest = longest+1
    //         dp[i]=newLongest
    //         longest=0
    //         if (newLongest> ans ){
    //             ans = newLongest
    //         }
    //     }
    //     return ans
    // }
}