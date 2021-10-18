fun findComplement(num: Int): Int {
    // 不包含前导0,找到第一个1,把后面的取反
    var ans = num
    var isLeftZero = true
    for (i in 31 downTo 0) {
        val flag = 1 shl i
        if (ans and flag == flag) {
            if (isLeftZero) {
                isLeftZero = false
            }
            // 这位是1 改0
            ans -= (1 shl i)
        } else {
            // 这里是0
            if (isLeftZero) {
                // 前导0跳过
                continue
            } else {
                // 非前导0 变成1
                ans += (1 shl i)
            }
        }
    }
    return ans
}