class Solution {
  lateinit var ns:IntArray
   var n=0
  /** 从i开始，可以组成多少个符合要求的子集 */
  fun dfs(i:Int,k:Int,path:MutableList<Int>):Int{
      if (i==n) return 0
      var ans = 1
      for (j in i+1 until n){
          if (path.contains(ns[j]-k)) continue
          path.add(ns[j])
          ans+=dfs(j,k,path)
          path.removeLast()
      }
      return ans
  }

  fun beautifulSubsets(nums: IntArray, k: Int): Int {
      // 找子集，所有数abs(a-b)!=k
      // 从小到大，找合适的数加入子集
      n = nums.size
      nums.sort()
      ns=nums
      return (0 until n).sumOf { dfs(it,k, mutableListOf(ns[it])) }
  }
}