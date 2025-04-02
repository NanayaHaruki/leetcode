class Solution {
  fun mostPoints(questions: Array<IntArray>): Long {
      // 从左往右遍历，遍历到i的时候无法知道从前面的哪个跳过来
      // 从右往左遍历，i的最大值就是i+skip+1+cur
      val n = questions.size
      val dp = LongArray(n+1)
      for(i in n-1 downTo 0){
          val (cur,skip) = questions[i]
          dp[i]=max(dp[i+1],cur+if(i+1+skip>=n) 0 else dp[i+1+skip])
      }
      return dp[0]
  }
}https://static.eudic.net/web/dict/star-off.png