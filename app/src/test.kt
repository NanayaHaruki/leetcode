import java.lang.StringBuilder
import java.util.*

fun main() {
    val s = Solution()
    val i = 1e9 + 7
    println(i.toInt())

}


class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        val n = citations.size
        var left = 0
        var right = n - 1
        while (left < right) {
            val mid = (left + right) / 2
            val num = citations[mid]
            val cnt = n - mid
            if (cnt > num) {
                left = mid + 1
            } else if (cnt <= num) {
                right = mid
            }
        }
        return if (citations[right] >= n - right) {
            n - right
        } else 0
    }
}

