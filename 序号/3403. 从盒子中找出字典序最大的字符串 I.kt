class Solution {
  fun answerString(word: String, numFriends: Int): String {
      if(numFriends==1) return word
      val n = word.length
      // 在n-1个位置，插numFriends个隔板，选择被隔开的字典序最大的字符串
      val len = n-numFriends+1
      var ans = ""
      for(l in 0 until n){
          word.substring(l,min(n,l+len)).also { 
              if(it > ans) ans = it
          }
      }
      return ans
  }
}