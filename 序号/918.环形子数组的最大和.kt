import kotlin.math.*

class Solution() {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        // 环形数组 求最大子序列和  每个元素只能用一次
        // 成环了 求最大和，那等同于找最小和，这样可以解决答案在数组头尾二段的情况；
        // 上面求最小和解决不了，最大子序列在中间的情况，只要再跑一次kanade算法即可，于上面互不影响，可以在一个循环里走完
        var preMin = 0
        var ansMin = Int.MAX_VALUE
        var preMax = 0
        var ansMax = Int.MIN_VALUE
        var sum = 0 // 遍历的同时求总和，减去最小和，就是答案
        for (num in nums) {
            sum += num
            preMin = min(preMin + num, num)
            ansMin = min(preMin, ansMin)

            preMax = max(preMax + num, num)
            ansMax = max(preMax, ansMax)
        }
        // sum = ansMin 数组全是负的，返回普通kanade的结果就行
        return if (sum - ansMin == 0) ansMax else max(ansMax, sum - ansMin)
    }
}