class Solution {
    /** 长度为偶数 一对数的和最小  求最小的最大数对和 */
    fun minPairSum(nums: IntArray): Int {
        // 那肯定不能大的和大的相加  让每对数平均
        // 先排序，再遍历一半，找最小的
        nums.sort()
        val n = nums.size
        var max = Int.MIN_VALUE
        for (i in nums.indices){
            val r = n-1-i
            if (i>r) break
            val sum = nums[i]+nums[r]
            max = max(max,sum)
        }
        return max
    }
}