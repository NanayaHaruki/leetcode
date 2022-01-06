class Solution {
    // 方法一  修改原数组了

    // fun findDuplicate(nums: IntArray): Int {
    //     // 找到重复的数字 nums[i]都在[1,n]有n个数字  nums.length为n+1,所以必然有至少一个重复
    //     // nums[i]在[1,n]中间，可以将值-1以对应索引，将这个索引上的值变成负数，当遍历时碰到重复数的时候，根据索引查之前的，如果为负就是重复数
    //     var j=0
    //     for (i in nums.indices){
    //         j = abs(nums[i])-1
    //         if (nums[j]<0){
    //             return abs(nums[i])
    //         }else {
    //             nums[j]=-nums[j]
    //         }
    //     }
    //     for (i in nums.indices) {
    //         if (nums[i]<0) nums[i]=-nums[i]
    //     }
    //     return -1
    // }

    // 方法二 二分法
    fun findDuplicate(nums: IntArray): Int {
        // nums中有n个数  但nums[i]只能是[1,n) 所以必定有重复的，也必定有数缺失了
        // 1 2 2 3
        // <=1的数有1个  <=2的有3个；当小于重复数时，数量等于该数；当包含重复数时，数量大于该数；
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val m = l + ((r - l) shr 1)
            // 找<=m的数在nums有几个
            var sum = 0
            for (num in nums) {
                if (num <= m) sum++
            }
            // 小于重复的数会有缺失
            if (sum <= m) l = m + 1
            else r = m - 1
        }
        return l
    }
}