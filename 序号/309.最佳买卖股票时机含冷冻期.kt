import kotlin.math.*

class Solution {
    fun maxProfit(prices: IntArray): Int {
        // 只有一只股票，找卖出最大利润
        // 可以多次交易 不能同一天交易多次
        // 因为当天的最大利润取决于昨天的最大利润，cur=preCur+(今天操作得到的利润)
        // 但今天操作的利润取决于昨天有没有买卖，所以需要再维护个变量，昨天持有股票和没有持有股票，这样就知道今天是买还是卖了
        // 比122题 增加cd 1s ，dp转移时需要考虑的维度有3个

        // 第一维是第几天  第二维表示当前持有状态 0未持有  1持有  的利润
        var have = -prices[0]
        var notHave = 0
        var preNotHave = 0
        for (i in 1 until prices.size) {
            // 第i天，持有
            val tmpNotHave = notHave
            have = max(have, preNotHave - prices[i])
            notHave = max(notHave, have + prices[i])
            preNotHave = tmpNotHave

        }
        return notHave
    }
}