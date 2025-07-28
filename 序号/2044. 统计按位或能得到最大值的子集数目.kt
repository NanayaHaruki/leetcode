class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        // 只有16个数，二进制表示集合，遍历子集，找最大就行
        val n = nums.size
        val s = (1 shl n) - 1
        var sub = s
        var ans = 0
        var ansCnt = 0
        while (sub > 0) {
            var cur = 0
            for (i in 0 until n) {
                if (sub.shr(i).and(1) == 1) cur = cur or nums[i]
            }
            if (cur == ans) ansCnt++
            else if (cur > ans) {
                ans = cur
                ansCnt++
            }
            sub = (sub - 1) and s
        }
        return ansCnt
    }
}