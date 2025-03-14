class Solution {
  fun isBalanced(num: String): Boolean {
      var a = 0
      var b = 0
      num.forEachIndexed { index, c -> 
          if(index.and(1)==1){
              a+=c-'0'
          }else{
              b+=c-'0'
          }
      }
      return a==b
  }
}