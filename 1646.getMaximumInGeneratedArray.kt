class Solution {
    fun getMaximumGenerated(n: Int): Int {
        val dp = IntArray(n+1)
        dp[0]=0
        dp[1]=1
        if (n==0) return 0
        var ans = 1
        for (i in 2..n){
            if (i%2==0) dp[i]=dp[i/2]
            else dp[i]=dp[i/2]+dp[i/2+1]
            if (dp[i]>ans) ans = dp[i]
        }
        return ans
    }
}