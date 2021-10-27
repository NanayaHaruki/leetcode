fun getMaxLen(nums: IntArray): Int {
    // 积为正的最长子数组
    // 遍历数组，遇到正数，最大长度+1,遇到0,清0。
    // 遇到负数，负数最大长度 为 正数最大长度+1.正数最大长度 为负数最大长度+1
    var posLen = 0
    var negLen = 0
    var ans = 0
    for (num in nums) {
        when {
            num == 0 -> {
                posLen = 0
                negLen = 0
            }
            num > 0 -> {
                // 当前是正数，之前是正数负数 乘上这个，长度都变。但之前没有负数的话，不存在负数*正数的情况，所以不变还是0
                posLen++
                negLen = if (negLen != 0) negLen + 1 else 0
            }
            else -> {
                // 当前是负数
                val tmpPosLen = posLen
                posLen = if (negLen != 0) negLen + 1 else 0
                negLen = tmpPosLen + 1
            }
        }
        if (posLen > ans) ans = posLen
    }
    return ans
}