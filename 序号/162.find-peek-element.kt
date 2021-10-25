class Solution {
    // 21 07 23
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (mid == nums.lastIndex || nums[mid] > nums[mid + 1]) {
                r = mid - 1
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1
            }
        }
        if (r == nums.lastIndex) return r
        else return r + 1

    }

    // 21-09-15  跟2个月前一个思路
    fun findPeakElement(nums: IntArray): Int {
        // 找峰值，数组本身没有排序
        // 对任意点，右边的比他大，右边肯定存在峰值，左边界收缩
        // 题设不可能相等，那么右边的小，当前点及当前点左侧必存在峰值，右边界收缩
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            val cur = nums[mid]
            // 边界外都是负无穷，右边界lastndex处也满足nums[mid] > nums[mid + 1]
            if (mid == nums.lastIndex || nums[mid] > nums[mid + 1]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }

}