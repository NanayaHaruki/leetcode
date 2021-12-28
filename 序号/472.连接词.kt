private val dict1 = mutableSetOf<Int>()
private val dict2 = mutableSetOf<Int>()
private val prime1 = 49999
private val prime2 = 44777
/** 找出words中能由其他单词拼接成的单词 */
fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
    // 先排序，由短到长，计算words每个word的hash。
    // dp[i]表示前i个字符能最多分成几个单词
    // 0 1 2 3 4 5  比如012 是一个单词，dp[3]=1   45经过hash计算，也是一个单词，那么dp[5]=dp[3]+1,
    // 当然遍历的时候，不是直接用=赋值，需要判断大小，不断更新为最大值

    for (word in words){
        var hash1 = 1
        var hash2 = 1
        for (c in word){
            hash1 = hash1*prime1+(c-'a')
            hash2 = hash2*prime2+(c-'a')
        }
        dict1.add(hash1)
        dict2.add(hash2)
    }
    val ans = mutableListOf<String>()
    for (word in words){
        if (check(word)){
            ans.add(word)
        }
    }
    return ans
}

private fun  check(word:String):Boolean{
    val n = word.length
    // dp[i]表示不包含word[i]那个字符的前面的字符可以拆分成的最大单词数
    val dp = IntArray(n+1){-1}
    dp[0]=0
    for (i in 0 until n){
        if (dp[i]==-1) continue
        var hash1 = 1
        var hash2 = 1
        for (j in i until n){
            hash1 = hash1*prime1+(word[j]-'a')
            hash2 = hash2*prime2+(word[j]-'a')
            if (dict1.contains(hash1)
                && dict2.contains(hash2)
                && dp[i]+1>dp[j+1]) {
                //这一步必须确保dp[i]不为0,即前i个字符可以组成一个单词，但初始值就是0
                // 所以初始值定为-1,在第一次遍历即i=0时，更新到0
                dp[j+1]=dp[i]+1
            }
        }
        if(dp[n]>1) return true
    }
    return false
}