class Solution {
  fun addSpaces(s: String, spaces: IntArray): String {
      var sb = StringBuilder()
      var i = 0
      for(x in spaces){
          while(i<x){
              sb.append(s[i++])
          }
          sb.append(' ').append(s[i++])
      }
      while(i<s.length) sb.append(s[i++])
      return sb.toString()
  }
}