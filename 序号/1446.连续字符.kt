fun maxPower(s: String): Int {
    // 最长非空子串长度
    val arr = s.plus(' ').toCharArray()
    var longestChar = arr[0]
    var len = 1
    var curChar = arr[0]
    var curLen = 1
    for (i in 1 until arr.size) {
        if (arr[i] == curChar) {
            curLen++
        } else {
            if (curLen > len) {
                longestChar = curChar
                len=curLen
            }
            curChar = arr[i]
            curLen = 1
        }
    }
    return len
}