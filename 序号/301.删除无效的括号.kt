fun removeInvalidParentheses(s: String): List<String> {
    // 删最小的括号，使字符串合法
    // bfs 每次删一个，有合法的就返回，没合法的就继续删
    val set = mutableSetOf<String>(s)

    val ans = mutableListOf<String>()
    while (set.isNotEmpty()) {
        // 判断上次循环删过的合不合法
        for (preStr in set){
            if (isValid(preStr)) {
                ans.add(preStr)
            }
        }
        if (ans.isNotEmpty()) return ans

        // 开始删
        val nextSet = mutableSetOf<String>()
        for (preStr in set){
            for (i in preStr.indices){
                val delStr = preStr.removeRange(i,i+1)
                nextSet.add(delStr)
            }
        }
        set.clear()
        set.addAll(nextSet)
    }
    return ans
}

fun isValid(s: String): Boolean {
    // ( )数量相同才合法，或遍历过程中出现）大于（的情况 直接返回不合法
    var flag = 0
    for (c in s) {
        if (c == '(') flag++
        else if (c == ')') flag--
        if (flag < 0) return false
    }
    return flag == 0
}