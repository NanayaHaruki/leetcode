import kotlin.math.*
class Solution {
    fun maxProduct(nums: IntArray): Int {
        // 最大积  如果负数数量为偶数，整个数组就是最大积
        // 负数的存在让最大值变成最小值 ，所以同时维护最大最小，其他和kadane一样
        var max = nums[0]
        var min = nums[0]
        var ans = nums[0]
        for (i in 1..nums.lastIndex){
            val mx = max
            val mn = min
            val num = nums[i]
            max = maxOf(num,mx*num,mn*num)
            min = minOf(num,mx*num,mn*num)
            ans = max(max,ans)
        }
        return ans
    }
}