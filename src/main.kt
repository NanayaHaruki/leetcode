fun main() {
    val i = Solution1().grayCode(5)
    for (j in i) {
        println(j.toString(2))
    }
}

class Solution1 {
    fun grayCode(n: Int): List<Int> {
        val sz = 1 shl n
        val q = MutableList(sz) { 0 }
        for (i in 0 until sz) {
            q[i] = i xor (i shr 1)
        }
        return q
    }
}
