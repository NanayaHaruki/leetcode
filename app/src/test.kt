import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    val s = Solution()
    val res = s.stoneGame(intArrayOf(5, 3, 4, 5))

    println(res)
}


class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        // 定义dp[i][j]为 i-j 的最大差值
        val dp = Array(piles.size){IntArray(piles.size)}
        // 状态转移 左边的 - 右边区间内的最大差值 or 右边的 - 左边区间的最大差值
        for (len in 1..piles.size){ // 区间长度，从1到整个数组长度
            val maxLeft = piles.size-len
            for (l in 0 .. maxLeft){ // 左边界
                val r = l+ len -1 // 右边界

                var left = piles[l]
                if (l+1<=piles.size-1) left-= dp[l+1][r]

                var right = piles[r]
                if (r-1>=0) right -= dp[l][r-1]

                dp[l][r]= max(left,right)
            }
        }
        return dp[0][piles.lastIndex]>0
    }


}

