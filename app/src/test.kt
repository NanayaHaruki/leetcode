import java.lang.StringBuilder
import java.util.*

fun main() {
    val s = Solution()
    val a = 'A'+1
    println(a)
}


class Solution {
    fun convertToTitle(columnNumber: Int): String {
        // 进制操作 都是% 取最后一位  在/ 去掉位数即可
        // 本题A为1 而不是常规的0,所以每次运算前需要-1 来位移
        var n = columnNumber
        val sb = StringBuilder()
        while(n>0){
            n--
            sb.append('A'+n%26)
            n/=26
        }
        return sb.reverse().toString()
    }
}

