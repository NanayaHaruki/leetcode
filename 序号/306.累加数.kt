fun isAdditiveNumber(num: String): Boolean {
    // 回溯 看前2个数怎么分  最少3个数，前2个数最多num/2位
    for (length in 2..num.length) {
        for (split in 1 until length) {
            if (check(num, length, split))
                return true
        }
    }
    return false
}

/** @param length 前2个数长度
 *  @param split 第1个数长度
 * */
fun check(num: String, length: Int, split: Int): Boolean {
    val n1Str = num.substring(0, split)
    val n2Str = num.substring(split, length)
    if (n1Str.length > 1) {
        for (element in n1Str) {
            if (element != '0') break
            else return false
        }
    }
    if (n2Str.length > 1) {
        for (element in n2Str) {
            if (element != '0') break
            else return false
        }
    }

    val n1 = n1Str.toLong()
    var n2 = n2Str.toLong()
    var n3 = (n1 + n2).toString()
    var _num = num.substring(length)
    while (n3.length <= _num.length) {
        val subN3 = _num.substring(0, n3.length)
        if (subN3 != n3)
            return false
        if (n3.length == _num.length)
            return true
        _num = _num.substring(n3.length)
        val n4 = (n2 + n3.toLong()).toString()
        n2 = n3.toLong()
        n3 = n4
    }
    return false
}