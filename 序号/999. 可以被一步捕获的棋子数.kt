class Solution {

  fun numRookCaptures(board: Array<CharArray>): Int {
      val m = board.size
      val n = board[0].size
      var (x,y) = IntArray(2)
      a@ for(i in 0 until m){
          for(j in 0 until n){
              if(board[i][j]=='R'){
                  x=i;y=j
                  break@a
              }
          }
      }
      var ans = 0
      for(r in x-1 downTo 0){
          when(board[r][y]){
              'B'->break
              'p'->{
                  ans++
                  break
              }
              else->continue
          }
      }
      for(r in x+1 until m){
          when(board[r][y]){
              'B'->break
              'p'->{
                  ans++
                  break
              }
              else->continue
          }
      }
      for(c in y-1 downTo 0){
          when(board[x][c]){
              'B'->break
              'p'->{
                  ans++
                  break
              }
              else->continue
          }
      }
      for(c in y+1 until n){
          when(board[x][c]){
              'B'->break
              'p'->{
                  ans++
                  break
              }
              else->continue
          }
      }
      return ans
  }
}