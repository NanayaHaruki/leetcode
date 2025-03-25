class Solution {
  fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
      val m = grid.size
      val n = grid[0].size
      // 第1遍遍历，存左上到该点不同值的数量，第2遍倒着遍历，数右下的数量
      val st = mutableSetOf<Int>()
      val ans = Array(m){IntArray(n)}
      for(i in 0 until m){
          var r = i
          var c = 0
          st.clear()
          while(r<m && c<n){
              ans[r][c]=st.size
              st.add(grid[r++][c++])
          }
      }
      for(j in 1 until n){
          var r = 0
          var c = j
          st.clear()
          while(r<m && c<n){
              ans[r][c]=st.size
              st.add(grid[r++][c++])
          }
      }
      // 第2遍，从右下往左上遍历
      for(i in m-1 downTo 0){
          var r = i
          var c = n-1
          st.clear()
          while(r>=0 && c>=0){
              ans[r][c]=abs(ans[r][c]-st.size)
              st.add(grid[r--][c--])
          }
      }
      for(j in n-2 downTo 0){
          var r = m-1
          var c = j
          st.clear()
          while(r>=0 && c>=0){
              ans[r][c]=abs(ans[r][c]-st.size)
              st.add(grid[r--][c--])
          }
      }
      return ans
  }
}