class Solution {
  fun losingPlayer(x: Int, y: Int): String {
      // x 够 拿 x 次； y 够拿 y/4 次
      val cnt = min(x,y/4)
      
      return if(cnt%2==1) "Alice" else "Bob"
  }
}