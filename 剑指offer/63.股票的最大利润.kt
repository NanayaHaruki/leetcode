class Solution {
  fun maxProfit(prices: IntArray): Int {
    // 只能买卖一次
    if(prices.isEmpty()) return 0
    var ans= 0
    var low = prices[0]
    for(i in 1 until prices.size){
      ans=maxOf(ans,prices[i]-low)
      low= minOf(low,prices[i])
    }
    return ans
  }
}