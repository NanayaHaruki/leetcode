class Solution {
  fun largestGoodInteger(num: String): String {
      var c = '0'-1
      for(i in 2 until num.length){
          if(num[i]==num[i-1] && num[i]==num[i-2]){
              if(num[i]>c){
                  c=num[i]
              }
          }
      }
      return if(c=='0'-1) "" else "$c$c$c"
  }
} 