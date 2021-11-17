fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    // 4数之和，和两数之和、三数之和一样，暴力需要n^4,利用两数之和的降低一次幂，排序需要logN,总时间N^3+logN
    // 固定2个，右边两个向中间缩进查找
    val n = nums.size
    nums.sort()
    val set = mutableSetOf<String>()
    var a = 0 //4个指针用abcd
    while (a <= n - 4) {
        var b = a + 1
        while (b <= n - 3) {
            var c = b + 1
            var d = n - 1
            val nA = nums[a]
            val nB = nums[b]
            while (c < d) {
                val nC = nums[c]
                val nD = nums[d]
                val t = target - nA - nB - nC - nD
                if (t == 0) {
                    set.add("${nA}_${nB}_${nC}_${nD}")
                    c++
                    d--
                } else if (t > 0) {
                    // nc+nd 小了
                    c++
                } else if (t < 0) {
                    d--
                }
            }
            b++
        }
        a++
    }
    return set.map { str->str.split("_").map { numStr->numStr.toInt() } }
}