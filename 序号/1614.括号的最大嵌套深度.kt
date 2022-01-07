fun maxDepth(s: String): Int {
    // 找括号的最大深度
    val chars = s.toCharArray()
    var ans = 0
    var cnt = 0
    for (c in chars){
        if (c == '(') {
            cnt++
            ans = maxOf(ans,cnt)
        }else if(c == ')'){
            cnt--
        }
    }
    return ans
}