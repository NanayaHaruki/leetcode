class Solution {
  fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
      // 排序二分
      val idcies = mutableListOf<Int>()
      nums.forEachIndexed { index, i -> if (i==x) idcies.add(index) }
      val ans = IntArray(queries.size)
      queries.forEachIndexed { index, i -> 
          if (i>idcies.size) ans[index]=-1
          else ans[index]=idcies[i-1]
      }
      return ans
  }
}