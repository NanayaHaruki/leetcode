class Solution {
  fun minSwaps(s: String): Int {
      // 消消乐
      var cnt = 0 // 左括号的数量
      for(x in s){
          if(x=='[')cnt++
          else{
              // 右括号，且前面没有左括号可以匹配，将这个视作左括号
              // 后面的某个左括号本应变成这个右括号，所以最终cnt就是所有出问题的位置，除2就是交换次数
              if(cnt==0) cnt++ 
              else cnt--
          } 
      }
      return cnt shr 1
  }
}