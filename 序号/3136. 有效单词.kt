class Solution {
  fun isValid(word: String): Boolean {
      if(word.length<3) return false
      var hasA = false
      var hasB = false
      val aeiou = arrayOf('a','e','i','o','u','A','E','I','O','U')
      for(c in word){
          if(c in '0'..'9'){
              continue
          }else if(c in aeiou){
              hasA = hasA or true
          }else if(c in 'a'..'z' || c in 'A'..'Z'){
              hasB = hasB or true
          }else return false
      }
      return hasA and hasB
  }
}