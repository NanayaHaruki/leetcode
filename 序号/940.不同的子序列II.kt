const val mod = (1e9 + 7).toInt()
class Solution {
  /** 子序列个数 */
  fun distinctSubseqII(s: String): Int {
    val dp = IntArray(26) // 以某个字母结尾的子序列的个数
    var sum =0 // 总共的子序列个数
    for (c in s){
      val preCnt = dp[c-'a'] // 之前以这个字母结尾的子序列个数
      dp[c-'a'] = (sum+1)% mod // 之前所有的子序列都可以 加上这个字母，变成这个字母结尾的子序列
      sum = ((sum*2+1-preCnt)%mod+mod) % mod // sum 和 dp[c-'a'] 取模了，可能比preCnt小,所以需要加上一个mod再取模
    }
    return sumK
  }
}