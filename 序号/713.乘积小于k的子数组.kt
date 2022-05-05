fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
  // 积 小于k的连续子数组个数
  // 滑动窗口 记录乘积，如果新数字加入后，积小于k，则答案增加 包括新数字的所有子数组，r-l+1个
  // 如果积大于等于k，左指针右移
  var l = 0
  var r = 0
  var ans = 0
  var multiPlus = 1
  while (r < nums.size) {
    multiPlus *= nums[r]
    if(multiPlus < k) {
      ans += r - l + 1
      // println("$r $l ${r-l+1} $ans")
    } else{
      while (l <= r) {
        multiPlus /= nums[l]
        l++
        if (multiPlus < k) {
          ans += r - l + 1
          // println("$r $l ${r-l+1} $ans")
          break
        }
      }
    }
    r++
  }
  // println(ans)
  return ans
}