class Solution {
  fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
      // 存一些不满足条件 的索引，查询的时候二分找查询区间内有没有这些捣蛋鬼
      // k放索引，v 0 两遍都满足  1 左边不满足 2 右边不满足 3 两遍都不满足
      val ts = TreeMap<Int, Int>()
      val ans = BooleanArray(queries.size)
      for (i in nums.indices) {
          if (i == 0) {
              if (nums.size > 1 && nums[i] % 2 == nums[1] % 2)
                  ts[0] = 2
          } else if (i == nums.size - 1) {
              if (nums[i] % 2 == nums[i - 1] % 2)
                  ts[i] = 1
          } else {
              var cur = 0
              if (nums[i] % 2 == nums[i - 1] % 2) {
                  cur = cur or 1
              }
              if (nums[i] % 2 == nums[i + 1] % 2) {
                  cur = cur or 2
              }
              if (cur > 0) {
                  ts[i] = cur
              }
          }
      }
      for (i in queries.indices) {
          val (from, to) = queries[i]
          // 不用判断边界a，如果a有问题，a+1必定也有问题，higher能找到
          val a = ts.higherKey(from) 
          if (a == null || a > to) {
              ans[i] = true
              continue
          }
          if (a == to && ts[a] == 2) {
              ans[i] = true
              continue
          }
      }
      return ans
  }
}