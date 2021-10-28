import kotlin.math.*

class Solution {
    fun maxProfit(prices: IntArray): Int {
        // 只有一只股票，找卖出最大利润
        // 可以多次交易 不能同一天交易多次
        // 因为当天的最大利润取决于昨天的最大利润，cur=preCur+(今天操作得到的利润)
        // 但今天操作的利润取决于昨天有没有买卖，所以需要再维护个变量，昨天持有股票和没有持有股票，这样就知道今天是买还是卖了

        var preBuy = -prices[0]
        var preNotBuy = 0
        for (i in 1 until prices.size){
            val tmpPreNotBuy = preNotBuy
            // 今天结束后不持有股票，本来就不持有，今天摸鱼，或者本来持有，今天卖了； 他俩之间求最大利润
            preNotBuy = max(preNotBuy,preBuy+prices[i])
            // 今天结束后持有股票，本来就持有 或 本来不持有，今天买入
            preBuy = max(preBuy,tmpPreNotBuy-prices[i])
        }
        return max(preBuy,preNotBuy)
    }
}