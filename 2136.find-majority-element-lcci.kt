class Solution {
    fun majorityElement(nums: IntArray): Int {
        // 选出数组中次数大于一般的元素 O(n) O(1)
        // 空间要求O(1) 只能用摩尔投票法 不断去除2个不同的数，剩下的就是答案

        var x = -1
        var cnt = 0
        for (num in nums){
            if (cnt == 0) x = num
            if (num == x){
                cnt++
            }else {
                cnt--
            }
        }
        cnt = 0
        for (num in nums){
            if (x == num) cnt++
        }
        if (cnt>nums.size/2){
            return x
        }else {
            return -1
        }
    }
}