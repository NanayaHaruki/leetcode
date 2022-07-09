/** 单调递增，二分找 */
fun lenLongestFibSubseq(arr: IntArray): Int {
  // 子序列的最长斐波那契数列的长度
  // 定义dp[j][i] 为arr[j] arr[i] 为数列最后两位的最大长度
  val dp = Array(arr.size-1){IntArray(arr.size)}
  var ans = 0
  for (i in 2 until arr.size){
    for (j in i-1 downTo 1){
      if (arr[j] *2<= arr[i]) break // 两个arr[j]大于arr[i]，才能找到更小的k能满足斐波那契条件
      val arrK = arr[i]-arr[j]
      // 在[0,j)范围内找arrK这个值
      val indexK = arr.binarySearch(arrK,0,j)
      if (indexK>=0){
        dp[j][i]= maxOf(3,dp[indexK][j]+1)
        ans= maxOf(ans,dp[j][i])
      }
    }
  }
  return ans
}

/** map找映射 */
fun lenLongestFibSubseq(arr: IntArray): Int {
  // 子序列的最长斐波那契数列的长度
  // 定义dp[j][i] 为arr[j] arr[i] 为数列最后两位的最大长度
  val dp = Array(arr.size-1){IntArray(arr.size)}
  var ans = 0
  val dict = mutableMapOf<Int,Int>()
  arr.forEachIndexed { index, i -> dict[i]=index }
  for (i in 2 until arr.size){
    for (j in i-1 downTo 1){
      if (arr[j] *2<= arr[i]) break // 两个arr[j]大于arr[i]，才能找到更小的k能满足斐波那契条件
      val arrK = arr[i]-arr[j]
      // 在[0,j)范围内找arrK这个值
      val indexK = dict.getOrDefault(arrK,-1)
      if (indexK>=0){
        dp[j][i]= maxOf(3,dp[indexK][j]+1)
        ans= maxOf(ans,dp[j][i])
      }
    }
  }
  return ans
}