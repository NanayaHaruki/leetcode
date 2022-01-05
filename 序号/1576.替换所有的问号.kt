fun modifyString(s: String): String {
    // 变更字符串中的？ 使其相连字符不重复
    // 碰到？ 查看左边右边的，从‘a’看可不可以，左边一定是字符，右边可能也是个？，那就先不管
    val chars = s.toCharArray()
    var pre: Char? = null
    var cur: Char? = null
    var next: Char? = null
    for (i in chars.indices) {
        cur = chars[i]
        if (cur == '?') {
            pre = chars.getOrNull(i - 1)
            next = chars.getOrNull(i + 1)
            var c = 'a'
            while (c == pre || c == next) {
                c++
            }
            chars[i] = c
        }
    }
    return String(chars)
}