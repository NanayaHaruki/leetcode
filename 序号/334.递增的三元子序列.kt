fun increasingTriplet(nums: IntArray): Boolean {
    // 判断是否存在最长上升子序列
    var a = nums[0]
    var b = Int.MAX_VALUE
    for (i in 1 until nums.size) {
        val n = nums[i]
        when {
            n > b -> return true
            n > a -> b = n
            else -> a = n
        }
    }
    return false
}