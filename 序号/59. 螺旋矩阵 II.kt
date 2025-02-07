class Solution {
  fun generateMatrix(n: Int): Array<IntArray> {
      val a = Array(n){IntArray(n)}
      var i = 0
      var j = -1
      var d = 0 // 方向
      var x = 0
      while(true){
          when(d){
              0->{
                  if(j==n-1 || a[i][j+1]!=0) d=1
                  else a[i][++j]=++x
              }
              1->{
                  if(i==n-1 || a[i+1][j]!=0) d=2
                  else a[++i][j]=++x
              }
              2->{
                  if(j==0 || a[i][j-1]!=0) d=3
                  else a[i][--j]=++x
              }
              3->{
                  if(i==0 || a[i-1][j]!=0) d=0
                  else a[--i][j]=++x
              }
              
          }
          if(x == n*n) break
      }
      return a
  }
}