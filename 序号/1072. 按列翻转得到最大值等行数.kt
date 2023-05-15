class Solution {
  fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
      // 每次翻转，所有行都会变，想要最大行数，就是找初始状态每行相同或每位都相反的最多有几个
      val dict = mutableMapOf<String,Int>()
      val m=matrix.size
      val n = matrix[0].size
      for(i in 0 until m){
          val sb0 = StringBuilder()
          val sb1=StringBuilder()
          for(j in 0 until n){
              sb0.append(matrix[i][j])
              sb1.append(1-matrix[i][j])
          }
          val row = if(sb0[0]=='0') sb0.toString() else sb1.toString()
          dict[row]=dict.getOrDefault(row,0)+1         
      }
      var ans =0
      for((k,v) in dict){
          if(v>ans) ans=v
      }
      return ans
  }
}