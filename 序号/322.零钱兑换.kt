class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // 定义dp[i]为凑i钱需要最小硬笔数量
        val dp = IntArray(amount+1){-1}
        dp[0]=0
        for (i in 0..amount){
            for (coin in coins){
                if (i-coin>=0 && dp[i-coin]!=-1) {
                    if(dp[i]==-1) dp[i]=dp[i-coin]+1
                    else if(dp[i-coin]+1 < dp[i]){
                        dp[i]=dp[i-coin]+1
                    }
                }
            }
        }
        return dp[amount]
    }
}