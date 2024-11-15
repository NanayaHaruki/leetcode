class Solution {
  fun minFlips(grid: Array<IntArray>): Int {
      val m = grid.size
      val n = grid[0].size
      var ans1 = 0
      for(i in 0 until m){
          for(j in (n+1)/2 until n){
              // j 对面的是 n-1-j
              if(grid[i][j]!=grid[i][n-1-j]) 
                  ans1++
          }
      }
      var ans2 = 0
      for(j in 0 until n){
          for(i in (m+1)/2 until m){
              if(grid[i][j]!=grid[m-1-i][j])
                  ans2++
          }
      }
      return min(ans1,ans2)
  }
}