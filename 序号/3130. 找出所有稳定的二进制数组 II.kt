class Solution {
    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val modulo = 1000000007L
        val a = Array(zero + 1) { LongArray(one + 1) }
        val b = Array(zero + 1) { LongArray(one + 1) }
        for (i in 1..minOf(zero, limit))
            a[i][0] = 1
        for (j in 1..minOf(one, limit))
            b[0][j] = 1
        for (i in 1..zero)
            for (j in 1..one) {
                a[i][j] = a[i - 1][j] + b[i - 1][j]
                if (i > limit)
                    a[i][j] -= b[i - limit - 1][j]
                a[i][j] = (a[i][j] + modulo) % modulo
                b[i][j] = a[i][j - 1] + b[i][j - 1]
                if (j > limit) 
                    b[i][j] -= a[i][j - limit - 1]
                b[i][j] = (b[i][j] + modulo) % modulo
            }
        return ((a[zero][one] + b[zero][one]) % modulo).toInt()
    }
}