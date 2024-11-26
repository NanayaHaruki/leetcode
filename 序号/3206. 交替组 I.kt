class Solution {
  fun numberOfAlternatingGroups(colors: IntArray): Int {
      val n = colors.size
      var ans = 0
      for(i in 0 until n){
          val b = colors[i]
          val a = colors[if(i-1<0) n-1 else i-1]
          val c = colors[if(i+1==n) 0 else i+1]
          if(a==c && a!=b){
              ans++
          }
      }
      return ans
  }
}