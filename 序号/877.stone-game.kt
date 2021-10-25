class Solution {
    // 方法一
    /*
    fun stoneGame(piles: IntArray): Boolean {
        val sum = piles.sum()
        val alexSum = bestChoice(piles, 0, piles.lastIndex, 0)
        return alexSum > (sum / 2)
    }

    /** 记忆化存放索引区间内的石头堆，可以获得的最大石头数，因为2人每次都做的最优选择 */
    val dict = mutableMapOf<String, Int>()
    private fun bestChoice(piles: IntArray, start: Int, end: Int, sum: Int): Int {
        val key = "${start}_${end}"
        if (dict[key] != null) return dict[key]!!

        if (start + 1 == end) { // 先选的人，最后剩2个，肯定拿大的；后选的拿最后一个
            val max = max(piles[start], piles[end])
            return sum + max
        }
        // 拿左边
        val left = sum + piles[start]
        // 对方会拿start+1，下次我拿 start+2 或end
        // 对方拿end，下次我拿start+1 或end-1
        val leftSum =
            left + max(
                bestChoice(piles, start + 2, end, left), // 我拿左边，对方也拿左边
                bestChoice(piles, start + 1, end - 1, left) // 我拿左边，对方拿右边
            )

        val right = sum + piles[end]
        val rightSum =
            right + max(
                bestChoice(piles, start + 1, end - 1, right), // 拿右边，对方拿左边
                bestChoice(piles, start, end - 2, left) // 拿右边，对方拿右边
            )
        val max = max(leftSum, rightSum)
        dict[key] = max
        return max

    }*/

    // 方法二 dp
    /*
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
    }*/


    // 方法三 博弈论
    fun stoneGame(piles: IntArray): Boolean {
       // 石头为奇数，不可能平局；石头数为偶数，2人选择次数相同；
       //  但凡后手能有获胜法，先手都可以选择这一组石头，所以先手必胜
        return true
    }
}