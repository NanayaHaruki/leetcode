class Solution {
  fun maxHeightOfTriangle(red: Int, blue: Int): Int {
      // red 第1层
      var a = sqrt(red.toDouble()).toInt()
      var b = ((sqrt(4.0*blue+1)-1)/2).toInt()
      var ans = when{
          a==b->a+b
          a>b->b*2+1
          else->a*2
      }

      // blue第1层
      a = sqrt(blue.toDouble()).toInt()
      b = ((sqrt(4.0*red+1)-1)/2).toInt()
      ans = max(ans, when{
          a==b->a+b
          a>b->b*2+1
          else->a*2
      })
      return ans
  }
}