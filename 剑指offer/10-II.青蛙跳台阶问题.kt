class Solution {
  fun numWays(n: Int): Int {
    // 青蛙可以跳1级 也可以跳2级，跳上n级有多少种跳法
    // 对i级台阶来说，只有2种跳法 1 从i-1跳上来 2，从i-2跳上来。 dfs或dp都可以
    val mod = (1e9+7).toInt()
    
    val dp = IntArray(n+1)
    var pre2=1;var pre1=1;var cur=0
    for (i in 2..n){
      cur=(pre2+pre1) % mod
      pre2=pre1;pre1=cur
    }
    return cur
  }
}