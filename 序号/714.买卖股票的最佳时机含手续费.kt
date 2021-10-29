import kotlin.math.*

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var have = -prices[0]
        var notHave = 0
        for (i in 1 until prices.size){
            val tmpHave = have
            have = max(have,notHave-prices[i])
            notHave = max(notHave,tmpHave+prices[i]-fee)
        }
        return notHave
    }
}