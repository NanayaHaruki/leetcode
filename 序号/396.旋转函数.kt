fun maxRotateFunction(nums: IntArray): Int {
  // 旋转nums.lengh -1 次，求0*nums[0]+1*nums[1]...的最大值
  // fn = fn-1 + sum  - n * nums[n-1]
  var pre = 0
  var sum = 0
  for (i in nums.indices) {
    pre += i * nums[i]
    sum += nums[i]
  }
  var ans = pre
  val n = nums.size
  println(pre)
  for (i in 1 until nums.size) {
    val cur = pre + sum - n * nums[n-i]
    ans = maxOf(ans, cur)
    pre = cur
    println(pre)
  }
  return ans
}