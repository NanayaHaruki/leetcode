class Solution {
  fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
      val sl = s.toLong()
      if (finish < sl) return 0
      val high = finish.toString().map { it-'0' }
      val n = high.size
      val m = s.length
      val diff = n - m
      val low = start.toString().padStart(n,'0').map { it-'0' }
      val suffix = s.padStart(n,'0').map { it-'0' }
      val mem = LongArray(n){-1}
      fun dfs(i: Int, lowLimit: Boolean, highLimit: Boolean): Long {
          if (i==n) return 1
          if(!lowLimit && !highLimit &&  mem[i]!=-1L) return mem[i] // 只记忆i就行，记忆的是i,false,false; 其他组合情况只会出现一次，不用记忆
          val lo = if (lowLimit) low[i] else 0
          val hi = if (highLimit) high[i] else 9 // 这里不能考虑limit,如果被限制了会影响后续dfs中的参数
          var ans = 0L
          if (i < diff) {
              for (j in lo..min(limit,hi)) {
                  ans += dfs(i + 1, lowLimit && j == lo, highLimit && j == hi)
              }
          } else {
              val j = suffix[i]
              if(j in lo..min(limit,hi)){
                  ans+=dfs(i+1,lowLimit && j==lo ,highLimit && j==hi)
              }
          }
          if(!lowLimit && !highLimit){
              mem[i]=ans
          }
          return ans
      }
      return dfs(0, true, true)
  }
}