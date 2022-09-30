/** 找出和为target的2个数，有多对返回一对 */

// 执行用时：528 ms, 在所有 Kotlin 提交中击败了82.61% 的用户
// 内存消耗：61 MB, 在所有 Kotlin 提交中击败了8.70% 的用户
// 通过测试用例：36 / 36
fun twoSum(nums: IntArray, target: Int): IntArray {
  var l = 0 ;var r = nums.size-1
  while (l<r){
    if (target-nums[l]<nums[r]) r--
    else if(target-nums[l]>nums[r])l++
    else return intArrayOf(nums[l],nums[r])
  }
  return intArrayOf()
}


// 执行用时：688 ms, 在所有 Kotlin 提交中击败了13.04% 的用户
// 内存消耗：61.2 MB, 在所有 Kotlin 提交中击败了8.70% 的用户
// 通过测试用例：36 / 36
fun twoSum(nums: IntArray, target: Int): IntArray {
  for (i in nums.indices){
    for(j in i+1 until nums.size){
      if (nums[i]+nums[j]==target)
        return intArrayOf(nums[i],nums[j])
    }
  }
  return IntArray(2)
}