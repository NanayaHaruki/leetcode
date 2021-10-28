import kotlin.math.*

class Solution {
    fun maxProfit(prices: IntArray): Int {
        // 只有一只股票，找卖出最大利润
        // 因为只能交易一次，遍历的时候，不断更新前面的最小值，同时继续最大差值
        var preMin = prices[0]
        var diff = Int.MIN_VALUE
        for (i in 1 until prices.size){
            diff = max(diff,prices[i]-preMin)
            preMin = min(preMin,prices[i])
        }
        diff = max(0,diff)
        return diff
    }
}