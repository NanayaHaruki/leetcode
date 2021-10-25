import kotlin.math.*
class Solution {
    fun maxProduct(nums: IntArray): Int {
        var pre = 1
        var ans = Int.MIN_VALUE
        for (num in nums){
            pre = max(pre*num,num)
            ans = max(pre,ans)
        }
        return ans
    }
}