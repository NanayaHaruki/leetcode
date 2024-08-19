const val mod = 1000000007

class Solution {
    fun checkRecord(n: Int): Int {
        // 定义f[i][j][k]为第i天缺席j次连续迟到k次的数量
        // 结果就是最后一天所有可能数量之和
        val f = Array(n) { Array(2) { IntArray(3) } }
        f[0][0][0] = 1
        f[0][0][1] = 1
        f[0][1][0] = 1
        for (i in 1 until n) {
           
            for (j in 0..1) {
                for (k in 0..2) {
                    // 正常出席，缺席保留，迟到清空
                    f[i][j][0] = (f[i][j][0] + f[i - 1][j][k]) % mod
                    if (k>0){ // 迟到了
                        f[i][j][k]=(f[i][j][k]+f[i-1][j][k-1]) % mod
                    }
                }
            }
            // 缺席
            for (k in 0..2){
                f[i][1][0]=(f[i][1][0]+f[i-1][0][k])% mod
            }

        }
        var ans = 0
        for (j in 0..1){
            for(k in 0..2){
                ans=(ans+f[n-1][j][k])% mod
            }
        }
        return ans
    }
}

const val mod = 1000000007

class Solution {
    val mem = mutableMapOf<Int, Int>()
    var n = 0
    fun dfs(i: Int, j: Int, k: Int): Int {
        if (i == 1) {
            if (j == 0 && k == 0) return 1
            if (j == 0 && k == 1) return 1
            if (j == 1 && k == 0) return 1
            return 0
        }
        if (j + k > i + 1) return 0
        // k为迟到次数，取值0，1，2 ，占2bit; j为缺席次数，取值0，1，占1bit
        val key = (i shl 3) or (j shl 2) or k
        if (mem.contains(key)) return mem[key]!!
        var ans = 0
        // 缺席
        if (j == 1 && k == 0) {
            for (_k in 0..2) {
                ans = (ans + dfs(i - 1, 0, _k)) % mod
            }
        }

        // 正常出席
        if (k == 0) {
            for (_k in 0..2) {
                ans = (ans + dfs(i - 1, j, _k)) % mod
            }

        }
        // 迟到
        if (k > 0) {
            ans = (ans + dfs(i - 1, j, k - 1)) % mod
        }
        mem[key] = ans
        return ans
    }

    fun checkRecord(_n: Int): Int {
        var ans = 0
        n = _n
        for (j in 0..1) {
            for (k in 0..2) {
                ans = (ans + dfs(n, j, k)) % mod
            }
        }
        return ans
    }
}