class Solution {
  fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Int {
       // 每切一刀，会让另一个方向的所有刀+1
      // 排序，前切大刀
      horizontalCut.sortDescending()
      verticalCut.sortDescending()
      var i = 0
      var j = 0
      var ans = 0
      while(i<m-1 || j<n-1){
          if (i<m-1 && j<n-1) {
              if (horizontalCut[i] > verticalCut[j]) {
                  ans += horizontalCut[i++] *(j+1)
              } else {
                  ans += verticalCut[j++] * (i+1)
              }
          }else if(i==m-1){
              ans+=verticalCut[j++] * (i+1)
          }else{
              ans+=horizontalCut[i++] * (j+1)
          }
      }
      return ans
  }
}