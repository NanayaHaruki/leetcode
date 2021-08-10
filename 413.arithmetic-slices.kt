class Solution {
    /* 方法一
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size<3) return 0
        // 找等差数列个数
        // dp[n]表示有几个等差数列，每遍历一个数和左右构成等差，会形成一个新的等差数列，再加上i-1处的等差数列数量
        val dp = IntArray(nums.size)
        var ans = 0
        for (i in 1..nums.size - 2) {
            if (nums[i-1]+nums[i+1]==nums[i]*2) {
                dp[i]=dp[i-1]+1
                ans+=dp[i]
            }
        }
        return ans
    }

     */

    /** 方法一可以看出dp只与上一个数有关，空间消耗可以优化到常量 */
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0
        var pre = 0
        var ans = 0
        for (i in 1..nums.size - 2) if (nums[i - 1] + nums[i + 1] == nums[i] * 2) ans += ++pre else pre=0
        return ans
    }
}