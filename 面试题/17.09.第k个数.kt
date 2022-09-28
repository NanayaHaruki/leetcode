/** 第k个只含质因数 357的数 */
fun getKthMagicNumber(k: Int): Int {
  // 每个数都由前面的数*357得到，就从最开始dp往后计算，找出最小值就是下一个数
  val dp = IntArray(k+1)
  var (p3,p5,p7,min) = intArrayOf(1,1,1,1) // 临时存放指针*3 5 7的数，判断大小
  var tmp3=0;var tmp5=0;var tmp7=0
  dp[1]=1
  for (i in 2 .. k){
    tmp3=3*dp[p3]
    tmp5=5*dp[p5]
    tmp7=7*dp[p7]
    min= minOf(tmp3,tmp5,tmp7)
    if (min==tmp3) p3++
    if(min==tmp5) p5++
    if(min==tmp7) p7++
    dp[i]=min
  }
  return dp[k]
}