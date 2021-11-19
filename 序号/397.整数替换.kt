import kotlin.math.min

class Solution {
    val dict = mutableMapOf<Int, Int>()
    fun integerReplacement(n: Int): Int {
        val value = dict[n]
        if (value != null) return value
        if (n == 1) return 0
        val ans = if (n % 2 == 0) {
            1 + integerReplacement(n / 2)
        } else {
            // 这里是2+ ，因为有一步加减，和一步除
            2 + min(integerReplacement(n / 2) , integerReplacement(n / 2 + 1))
        }
        dict[n] = ans
        return ans
    }
}