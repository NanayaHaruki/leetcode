class Solution {
  fun findLHS(nums: IntArray): Int {
      nums.sort()
      val tree = TreeMap<Int, Int>()
      for (x in nums) tree.merge(x, 1, Int::plus)
      val ite = tree.iterator()
      var preX = -1_000_000_001
      var preCnt = 0
      var ans = 0
      while (ite.hasNext()) {
          val (x, cnt) = ite.next()
          if (x == preX + 1) {
              ans = max(ans, cnt + preCnt)
          }
          preX = x
          preCnt = cnt

      }
      return ans
  }
}