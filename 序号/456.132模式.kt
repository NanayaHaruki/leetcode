class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        // 132 用x1 x2 x3表示
        // 维护单调栈，栈底最大，往上递减。遍历到i时，往栈内添加。如果i大于栈顶，就弹栈直到i可以添加，栈顶变成x3候选。弹栈的数用x2记录最大
        // 这样当k有值时，必然栈顶为j  k为k，j>k,遍历时判断i<j即满足条件
        val q = ArrayDeque<Int>()
        var x2 = Int.MIN_VALUE
        for (i in nums.lastIndex downTo 0){
            val x1 = nums[i]
            if (x1<x2) return true
            while (q.isNotEmpty() && q.peekLast()<x1) {
                val peek = q.pollLast()
                x2 = maxOf(x2,peek)
            }
            q.offerLast(x1)
        }
        return false
    }
}