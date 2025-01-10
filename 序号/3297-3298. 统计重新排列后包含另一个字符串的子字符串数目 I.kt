class Solution {
  fun validSubstringCount(word1: String, word2: String): Long {
      if (word1.length<word2.length) return 0
      val d = IntArray(26)
      for (c in word2){
          d[c-'a']++
      }
      var less = 0 // 差了几种字符
      for (i in 0 until 26){
          if (d[i]>0) less++
      }
      var ans = 0L
      var l = 0
      for (c in word1){
          d[c-'a']--
          if (d[c-'a']==0){ // c 这个字符够了
              less--
          }
          while (less==0){ // 所有字符都满足，右移左边界
              if (d[word1[l]-'a']==0){
                  less++ // 如果l更好够的话，下面l要右移，移完了，不符合的字符会多一个
              }
              d[word1[l++]-'a']++
          }
          ans+=l
      }
      return ans
  }
}