fun countAndSay(n: Int): String {
    if (n == 1) return "1"
    var pre = "1"
    for (i in 2..n) {
        pre = createCount(pre)
    }
    return pre
}

fun createCount(pre: String): String {
    val sb = StringBuilder()
    var cnt = 0
    var c: Char? = null
    for (i in pre.indices) {
        if (c == null) {
            c = pre[i]
            cnt = 1
        } else {
            val curChar = pre[i]
            if (curChar == c) {
                cnt++
            } else {
                // 字符变化或完结的时候，加入sb
                sb.append("$cnt$c")
                c = curChar
                cnt = 1
            }
        }
    }
    sb.append("$cnt$c")
    return sb.toString()
}