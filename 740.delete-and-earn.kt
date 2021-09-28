import kotlin.math.*
class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        // 这还是打家劫舍，偷了一家，周围2家不能偷
        val transNums = IntArray(10001) // transums[999]=888 表示999这个数字出现了888次
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (i in nums){
            if (i<min) min = i
            if (i>max) max = i
            transNums[i]++
        }
        var noRob = 0
        var rob = 0
        for (i in min..max){
            val curRob = noRob+i*transNums[i]
            noRob = max(rob,noRob)
            rob = curRob
        }
        return max(rob,noRob)
    }
}