class Solution {
  fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
      val m = img.size
      val n = img[0].size
      val ans = Array(m){IntArray(n)}
      val directions = intArrayOf(-1,0,1,0,-1)
      for(i in 0 until m){
          for(j in 0 until n){
              var cnt = 0
              var sum = 0
              for(x in i-1..i+1){
                  for(y in j-1..j+1){
                      if(x<0 || y<0 || x>=m || y>=n) continue
                      sum += img[x][y]
                      cnt++
                      
                  }
              }
              ans[i][j]=sum/cnt
          }
      }
      return ans
  }
}