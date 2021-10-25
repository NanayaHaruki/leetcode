package main.kotlin
import kotlin.math.*
fun main() {
    val s = Solution()
    println(
        s.maxProduct(intArrayOf(-2,3,-4))
    )
}

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