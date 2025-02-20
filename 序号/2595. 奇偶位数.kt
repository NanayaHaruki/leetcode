class Solution {
  fun evenOddBit(n: Int): IntArray {
      var x = n
      var ans = IntArray(2)
      for(i in 0 until 31){
          if(x.shr(i).and(1)==1){
              if(i%2==0){
                  ans[0]++
              }else{
                  ans[1]++
              }
          }
      }
      return ans
  }
}