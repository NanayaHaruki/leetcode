/** 正整数数组中找升序子序列和的最大值 */
fun maxAscendingSum(nums: IntArray): Int {
  // 因为不用考虑负数，所以子序列越长，和越大
  var max = 0
  var sum = 0
  var pre = 0
  for (i in nums){
    if (i>pre){
      sum+=i
      pre=i
    }else{
      max = maxOf(max,sum)
      sum=i
      pre=i
    }
  }
  return maxOf(max,sum)
}