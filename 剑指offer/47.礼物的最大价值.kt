class Solution {
  fun maxValue(grid: Array<IntArray>): Int {
    // 指定dp[i][j]为到达(i,j)位置的最大礼物值，他只能从上方下来或从左方过来
    val dp = Array(grid.size){IntArray(grid[0].size)}
    for(i in grid.indices){
      for(j in grid[0].indices){
        if(i==0 && j==0)
          dp[0][0]=grid[0][0]
        else
          if(i==0) dp[i][j]=dp[0][j-1]+grid[i][j]
          else if(j==0) dp[i][j]=dp[i-1][j]+grid[i][j]
          else dp[i][j]=maxOf(dp[i-1][j],dp[i][j-1])+grid[i][j]
      }
    }
    return dp.last().last();
  }
}