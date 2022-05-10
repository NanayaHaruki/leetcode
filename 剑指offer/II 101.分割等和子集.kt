fun canPartition(nums: IntArray): Boolean {
  // 数组能否分割2个和等的子数组
  // 就是背包问题，能否数组中取出和为sum/2 的数
  // dp，状态1 前面几个数 状态2 取其中几个数的和 ；选择 取不取当前的数
  val sum = nums.sum()
  if (sum%2!=0) return false
  val dp = Array(nums.size+1){BooleanArray(sum+1)} // 和最多不会超过sum
  // 一个数都不拿，和为0
  for (i in nums.indices) dp[i][0]=true
  for (i in nums.indices){
    // i为遍历到第几个数，用上这个数的话为dp[i+1]
    // 遍历之前和的可能性，拿当前的，和增加。不拿和不变
    for (j in 0..sum) {
      dp[i+1][j]= dp[i][j] or  if (j>=nums[i]) dp[i][j-nums[i]] else false
    }
  }
  return dp[nums.size][sum/2]
}