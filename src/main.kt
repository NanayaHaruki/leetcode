fun main() {
    val a  = arrayOf(intArrayOf(4,3,5),intArrayOf(2,1,5))
    a.sort{a:IntArray,b:IntArray-> a[0]-b[0]}
    println(a)
}

class Solution1 {
    fun fullBloomFlowers(flowers: Array<IntArray>, persons: IntArray): IntArray {
        val n = persons.size
        flowers.sort{a,b-> a[0]-b[0]}
        val ans = IntArray(n)

        return ans
    }
}
