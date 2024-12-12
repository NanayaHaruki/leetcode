class Solution {
  fun maxSpending(values: Array<IntArray>): Long {
      // 越往后d越大，先买便宜的
      var ans = 0L
      values.flatMap { it.toList() }
      .sorted().
      forEachIndexed { index, i -> 
          ans += 1L*(index+1)*i 
      }
      return ans
  }
}