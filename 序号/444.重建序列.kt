/**
执行结果：
通过
显示详情

添加备注
执行用时：368 ms, 在所有 Kotlin 提交中击败了66.67% 的用户
内存消耗：45.8 MB, 在所有 Kotlin 提交中击败了33.33% 的用户
通过测试用例：83 / 83
 */
class Solution {
  fun sequenceReconstruction(nums: IntArray, ss: Array<IntArray>): Boolean {
    val n = nums.size
    val graph = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
    val inArr = IntArray(n + 1)
    for (s in ss) {
      for (i in 1 until s.size) {
        if (graph[s[i - 1]].add(s[i]))
          inArr[s[i]]++
      }
    }
    val q = ArrayDeque<Int>()
    for (i in 1..n) {
      if (inArr[i] == 0)
        q.addLast(i)
    }
    var idx = 0
    while (q.isNotEmpty() && idx < n) {
      if (q.size > 1)
        return false
      if (nums[idx] != q.removeFirst())
        return false
      for (i in graph[nums[idx]]) {
        inArr[i]--
        if (inArr[i] == 0)
          q.addLast(i)
      }
      idx++
    }
    if (q.isNotEmpty() && idx == n) return false
    if (q.isEmpty() && idx < n) return false
    return true
  }
}