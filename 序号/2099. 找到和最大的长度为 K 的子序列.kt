class Solution {
  fun maxSubsequence(nums: IntArray, k: Int): IntArray {
      // 返回和最大的子序列，找到最大的k个数的索引，按顺序排好
      return nums.mapIndexed { index, i -> intArrayOf(index,i) }.sortedByDescending { it[1] }.subList(0,k).sortedBy { it[0] }.map { it[1] }.toIntArray()
  }
}