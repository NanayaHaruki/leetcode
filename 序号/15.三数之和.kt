fun threeSum(nums: IntArray): List<List<Int>> {
    // 找所有和为0，搞3个指针，左指针和右指针固定，中指针在他俩指针中间移动寻找答案
    // 左指针和右指针的移动是N，中指针每次循环最差到N，总时间复杂度N^2
    var l = 0
    val set = mutableSetOf<String>()
    nums.sort()
    while (l <= nums.size - 3) {
        var m = l + 1
        var r = nums.size - 1
        val numL = nums[l]
        while (m < r) {
            val numM = nums[m]
            val numR = nums[r]
            val sum = numL + numM + numR
            if (sum == 0) {
                set.add("${numL}_${numM}_${numR}")
                m++
                r--
            } else if (sum < 0) {
                m++
            } else if (sum > 0) {
                r--
            }
        }
        l++
    }
    return set.map { it.split("_").map { num -> num.toInt() }.toList() }
}