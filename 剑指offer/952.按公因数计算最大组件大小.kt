/**
 * 执行用时：4588 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
内存消耗：47.9 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
通过测试用例：108 / 108
 * */

import kotlin.math.max

class Solution {
  
  class UF(val n: Int) {
    private val parent = IntArray(n)
    var maxSize = 1
    val size = IntArray(n) { 1 }
    
    init {
      for (i in 0 until n) parent[i] = i
    }
    
    var count = n
    
    fun find(i: Int): Int {
      if (parent[i] != i) parent[i] = find(parent[i])
      return parent[i]
    }
    
    fun union(i: Int, j: Int) {
      val rootI = find(i);
      val rootJ = find(j);
      if (rootI != rootJ) {
        parent[rootI] = rootJ
        size[rootJ] += size[rootI]
        maxSize = max(maxSize, size[rootJ])
        count--
      }
    }
  }
  
  fun primesOla(n: Int): List<Int> {
    val isPrimes = BooleanArray(n + 1) { true }
    val l = mutableListOf<Int>()
    for (i in 2..n) {
      if (isPrimes[i]) l.add(i)
      for (j in l) {
        if (i * j > n) break
        isPrimes[i * j] = false
        if (i % j == 0) break
      }
    }
    return l
  }
  
  val primes = primesOla(100000)
  fun largestComponentSize(nums: IntArray): Int {
    val uf = UF(nums.size)
    // nums 中两数之间有公因数，则两数有边，返回连通组件的大小
    // 每个数找出质因数用map映射 ，遍历完nums后检查map中映射values最大的一组
    val d = mutableMapOf<Int, MutableList<Int>>()
    for (j in nums.indices) {
      val n = nums[j]
      for (i in primes) {
        if (i > n) break
        if (n % i == 0) {
          if (d.contains(i))
            d[i]!!.add(j)
          else
            d[i] = mutableListOf(j)
        }
      }
    }
    for (v in d.values) {
      for (i in 1 until v.size) {
        uf.union(v[i], v[0])
      }
    }
    return uf.maxSize
  }
}