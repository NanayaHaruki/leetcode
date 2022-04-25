import kotlin.random.Random
class Solution(val nums: IntArray) {
  /** nums有多个target 随机返回索引 */
  fun pick(target: Int): Int {
    // 池塘采样法，遍历数组遇到target就从已经遇到的个数中随机到0就返回当前。
    // 这样保证每次遇到的概率相等
    var cnt = 0
    var ans = 0
    for (i in nums.indices) {
      if (nums[i] == target) {
        cnt++
        if (0 == Random.nextInt(cnt)) {
          ans = i
        }
      }
    }
    return ans
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */