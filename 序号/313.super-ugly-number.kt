class Solution {
    fun nthSuperUglyNumber(n: Int,primes:IntArray): Int {
        val dp = IntArray(n+1)
        // 质因数2 3 5,找第n个丑数
        // 用dp存，dp[n]为答案
        dp[1] = 1
        val points = IntArray(primes.size){1}
        val temp = IntArray(primes.size)
        for (i in 2..n) {
            var min = Int.MAX_VALUE
            for (pi in points.indices){
                val n = dp[points[pi]]*primes[pi]
                temp[pi]=n
                if (n<min) min=n
            }

            for (ti in temp.indices) {
                if (temp[ti]==min) points[ti]++
            }
            dp[i] = min
        }
        return dp[n]
    }
}