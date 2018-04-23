// 给两个数，求和。
// 不可以使用BigInteger类，也不可以将他们转换成Integer
class Solution {
    fun addStrings(num1: String, num2: String): String {
        // 不可以转成Int，那么就将Char当做Int来计算就是了
        val sb = StringBuilder()
        var carryBit = 0
        var i = num1.length - 1
        var j = num2.length - 1
        while (i >= 0 || j >= 0 || carryBit == 1) {
//            a和b根据i和j的值，分别就能得到数字的最后一位，倒数第二位。。。
//            将a和b相加 模10  就是所得的值，进位由carryBit保存，带入到下一次循环
            val a = if (i < 0) 0 else num1[i].toInt() - '0'.toInt()
            val b = if (j < 0) 0 else num2[j].toInt() - '0'.toInt()
            sb.append((a + b + carryBit) % 10)
            carryBit = (a + b + carryBit) / 10
            i--
            j--
        }
        return sb.reverse().toString()
    }
}
