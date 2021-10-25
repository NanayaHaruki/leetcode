class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        // 将被除数不断二分，找商
        // mid*divisor<dividend ,mid+1
        // mid*divisor > dividend ,mid-1

        if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
        // 先判定符号
        val isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)

        // 负数范围大，统一用负数计算
        var a = dividend
        if (dividend > 0) a = -a
        var b = divisor
        if (divisor > 0) b = -b

        // 将除数不断自增，用被除数-最大除数，答案增加相应角标
        // 34/6
        // 1. 在tmp中自增6,直到小于34  [6 12 24] 即6*2_0  6*2_1 .. 6*2_i
        // 2. 倒序 ，34-24=10  24角标为2,表示这个有2的2次方的6,答案0+4=4
        // 3. 继续倒序，12超过10了，继续倒序 10-6=4  6角标为1 ,有2的0次方的6,答案4+1=5
        // 4. 4继续倒序找，找不到了，答案就是5

        val bList = mutableListOf<IntArray>()
        var x = b
        var cnt = -1
        bList.add(intArrayOf(cnt, x))
        while (x > a && x >= Int.MIN_VALUE - x) {
            x += x
            cnt += cnt
            bList.add(intArrayOf(cnt, x))
        }
        var ans = 0
        for (i in bList.lastIndex downTo 0) {
            val (j, k) = bList[i]
            if (k >= a) {
                a -= k
                ans += j
            }
        }
        return if (isPositive) -ans else ans
    }
}