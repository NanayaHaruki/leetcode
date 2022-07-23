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


/**
 *
 *
 * */
/*
class Solution {
 
  var n = 0
  fun sequenceReconstruction(nums: IntArray, ss: Array<IntArray>): Boolean {
    // 子序列sequences约束了数的前后关系，对sequences建图，进行拓扑序，同时与nums进行对比，有不同的直接返回false
    n = nums.size
    val graph = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
    val inIdx = IntArray(n + 1)
    
    // 建图
    for (s in ss) {
      for (i in 1 until s.size){
        graph[s[i-1]].add(s[i])
      }
    }
    for (i in 1..n){
      val linkSet = graph[i]
      for (j in linkSet){
        inIdx[j]++
      }
    }
    
    // 排序
    // 入度为0，如果不唯一，则拓扑序不唯一，直接返回false
    var idx = 0
    var from = 0
    val set = mutableSetOf<Int>()
    for (i in 1..n) set.add(i)
    while (idx < n) {
      // 找入度为0的数
      val l = search(set, inIdx)
      if (l.size > 1)
        return false // 有多个入度为0，拓扑序不唯一
      if (l.isEmpty())
        break // 找不到了，推出循环，检查是否与nums长度一致
      from = l[0]
      if (from != nums[idx])
        return false //检查是否与nums对应
      idx++
      set.clear()
      val next = graph[from]
      for (i in next) inIdx[i]--
      set.addAll(next)
    }
    if (set.isNotEmpty() || idx < n)
      return false
    return true
  }
  
  /** 找入度为0的数 */
  fun search(set: Set<Int>, inIdx: IntArray): List<Int> {
    val ans = mutableListOf<Int>()
    for (i in set) {
      if (inIdx[i] == 0) {
        ans.add(i)
      }
    }
    return ans
  }
}
*/