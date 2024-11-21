class Solution {
  fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
      var i = 0
      var j = 0
      for(s in commands){
          when(s[0]){
              'D'->i++
              'U'->i--
              'L'->j--
              'R'->j++
          }
      }
      return i*n+j
  }
}