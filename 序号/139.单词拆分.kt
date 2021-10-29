class Solution {
    /* ----------- DFS----------------
    val memory = mutableMapOf<String,Boolean>()
    lateinit var set: MutableSet<String>
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // s能否拆分为dict中的字符串
        set = wordDict.toMutableSet()
        return dfs(s)
    }

    fun dfs(s: String): Boolean {
        if (memory[s]!=null) return memory[s]!!
        if (set.contains(s)) return true
        for (i in 1 until s.length) {
            val leftPart = s.substring(0,i)
            if (set.contains(leftPart)) {
                memory[leftPart]=true
                val rightPart = s.substring(i)
                val result = dfs(rightPart)
                memory[rightPart]=result
                if (result) {
                    return true
                }
            }
        }
        return false
    }

     */

    /*  ------------ DP ----------------*/
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // s 能否拆分成dict中的字符串
        // 用dp数组记录短的字符能否被拆分 dp[i] 取决于 dp[0,j)有能被拆分的  且s(j,len)被dict包含
        val set = wordDict.toSet()
        val dp = BooleanArray(s.length)
        dp[0] = set.contains(s.substring(0, 1))
        if (s.length == 1) return dp[0]
        // 将字符拆分2部分
        for (i in 1 until s.length) {
            if (set.contains(s.substring(0,i+1))) {
                dp[i]=true
                continue
            }
            for (j in 0 .. i) {
                if (dp[j] && set.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp.last()
    }
}