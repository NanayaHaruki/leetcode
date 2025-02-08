class Solution {
  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
      // 到一个点的数量等于到左边点的数量+上面点的数量
      val mem = IntArray(1.shl(16)){-1}
      fun dfs(i:Int,j:Int):Int{
          if(i==0 && j==0) return 1-obstacleGrid[0][0]
          if(obstacleGrid[i][j]==1) return 0
          val k = i.shl(8).or(j)
          if(mem[k]!=-1) return mem[k]
          val v = if(i==0) dfs(0,j-1)
          else if(j==0) dfs(i-1,0)
          else dfs(i-1,j)+dfs(i,j-1)
          mem[k]=v
          return v
      }
      val m = obstacleGrid.size
      val n = obstacleGrid[0].size
      if(obstacleGrid[m-1][n-1]==1) return 0
      return dfs(m-1,n-1)
  }
}