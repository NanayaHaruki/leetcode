class Solution {
  fun quickPower(a:Int,_b:Int,m:Int):Int{
      var ans = 1.0
      var b = _b
      while(b>0){
          if((b and 1) == 1){
              ans=ans*a*quickPower(a,b/2,m)%m
          }else{
              ans=ans*quickPower(a,b/2,m)%m
          }
          b = b shr 1
      }
      return ans.toInt()
  }
          
  fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
      val ans = mutableListOf<Int>()
      for(i in variables.indices){
          val (a,b,c,m) = variables[i]
          if(quickPower(quickPower(a,b,10),c,m)==target){
              ans.add(i)
          }
      }
      return ans
  }
}