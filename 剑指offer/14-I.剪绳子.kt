import kotlin.math.max
class Solution {
  fun cuttingRope(n: Int): Int {
    // 剪绳子，求每段长度的积最大
    val dp = IntArray(n+1)
    dp[0]=0;dp[1]=0 // 0 和 1 不可再分割
    // 每次剪短，剪的长度都可以是[1,n-1] ,剪1刀，积为k*(n-k) ,剪n刀，dp[k]*(n-k)
    for(i in 2..n){
      for (j in 1..i-1){
        dp[i]=max(dp[i],max(j*(i-j),dp[j]*(i-j)))
      }
    }
    return dp[n]
  }
}