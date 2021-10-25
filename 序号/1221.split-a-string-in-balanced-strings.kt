class Solution() {
    fun balancedStringSplit(s: String): Int {
        // 碰到相同的，加一个，碰到不同的，减一个，减到0,答案增1。减完了不为0,不能分割返回1
        var c = s[0]
        var cnt = 1
        var ans = 0
        for (i in 1 until s.length) {
            val cur = s[i]
            if (cnt == 0) {
                ans++
                c = cur
                cnt++
            } else {
                if (cur == c) cnt++
                else {
                    cnt--
                }
            }
        }
        // 最后一个统计不到，ans要加1
        return if (cnt==0) ans+1 else 1
    }
}