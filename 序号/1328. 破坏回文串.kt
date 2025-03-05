class Solution {
  fun breakPalindrome(palindrome: String): String {
      val n = palindrome.length
      if(n==1){
          return "" // 就一个，怎么改都还是回文
      }
      var isChanged = false
      val chrArr = palindrome.toCharArray()
      for(i in 0 until n){
          if(n%2==1 && i==n/2) continue // 改中间的没用，还是回文
          if(chrArr[i]!='a'){
              chrArr[i]='a'
              isChanged=true
              break
          }
      }
      if(!isChanged){ // 没改过，说明全是a
          chrArr[n-1]='b'
      }
      return String(chrArr)
  }
}