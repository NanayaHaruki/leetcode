import kotlin.math.pow
class Solution {
    fun findNthDigit(n: Int): Int {
        // 求1..n 中的第n个数字  11算2个数字  100算3个数字
        // 规律：三位数范围[100,999] 为 10^(3-1),10^3-1
        // 不断累积，算出目标在哪个长度上，得出长度的起始点，因为长度固定了，可以直接算出所求的数

        // base case
        var len = 1
        var (start, end) = 1L to 9L
        var k = 9L // len长度的数字上有多少个数

        while (k < n) {
            len++
            start *= 10
            end = end * 10 + 9
            k += len * (end - start + 1)
        }

        // 找到长度len了，现在要找到哪个数
        // start+len*i = n
        // len长度 总共有 10^len-10^(len-1)个数
        k -= ((10.0.pow(len) - 10.0.pow(len - 1)) * len).toLong()
        val i = (n - k-1) / len //这个长度的第几个数
        val mod = (n - k - 1).toInt() % len //这个数的第几位
        val ansNum = (10.0.pow(len - 1) + i ).toInt()
        return ansNum.toString()[mod]-'0'
    }
}