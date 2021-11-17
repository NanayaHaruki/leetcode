fun maxProduct(words: Array<String>): Int {
    // 字母不重，长度积最大
    // 将字母26个放到int的32位上去
    val n = words.size
    val transWords = IntArray(n)
    for (i in words.indices){
        var trans = 0
        for (c in words[i]){
            trans = trans or charToInt(c)
        }
        transWords[i]=trans
    }
    var ans = 0
    for (i in 0 until n-1){
        for (j in i+1 until n){
            val a = transWords[i]
            val b = transWords[j]
            if (a and b ==0){
                // 与完了是0,说明所有位置都不重合，计算长度积
                ans = maxOf(ans,words[i].length*words[j].length)
            }
        }
    }
    return ans
}

private fun charToInt(char:Char):Int{
    return 1 shl char-'a'
}