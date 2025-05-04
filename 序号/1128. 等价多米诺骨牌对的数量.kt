class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        // 总共D[i][j]<=9,统计有多少种数对
        val cnt = Array(10){IntArray(10)}
        var ans = 0
        for((a,b) in dominoes){
            val mn = min(a,b)
            val mx = max(a,b)
            ans += cnt[mn][mx]++
        }
        return ans
    }
}