import kotlin.math.pow
fun dicesProbability(n: Int): DoubleArray {
  // 定义dp[i][j]为掷了i次骰子，和为j的出现次数
  //basecase
  val dp = Array(n+1){IntArray(n*6+1)} // n个骰子最多掷出6n
  // 第i次掷，和为 [i,6i]
  for(i in 1..6) dp[1][i]=1
  for(i in 1 until n){
    for (j in 1..6){
      for(k in i..6*i){ // 6-6i 是本次投应该有的总点数
        dp[i+1][k+j]+=dp[i][k]
      }
    }
  }
  val ans= DoubleArray(5*n+1)
  val total = 6.0.pow(n)
  for (i in ans.indices){
    ans[i]=dp[n][n+i]/total
  }
  return ans
}