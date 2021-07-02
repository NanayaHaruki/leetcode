import java.lang.StringBuilder
import java.util.*

fun main() {
    val s = Solution()
    val a = s.maxIceCream(intArrayOf(1,6,3,1,2,5),20)
    println(a)
}


class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var left = coins
        for (i in costs.indices){
            left-=costs[i]
            if (left<0){
                return i
            }
        }
        return costs.size
    }
}

