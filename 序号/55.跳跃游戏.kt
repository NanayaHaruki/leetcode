import kotlin.math.max
class Solution {
    fun canJump(nums: IntArray): Boolean {
        // 从第一级开始跳，找出最远距离，
        // 在最远距离范围内遍历，尝试刷新最远距离
        // 最远距离超过目标，返回true，循环走完了没到目标，返回false
        var max = nums[0]
        val target = nums.lastIndex
        var cur = 0
        while (cur<=max){
            max = max(max,cur+nums[cur])
            cur++
            if (max>=target) return true
        }
        return false
    }
}