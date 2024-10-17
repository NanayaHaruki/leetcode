class Solution {
  val MOD = 1e9.toInt()+7
  val d = mutableMapOf<Int,Int>()
  fun dfs(i:Int,j:Int,req:IntArray):Int{
      // 在0-i，可以产生j个逆序对的排列有多少个
      if(i==0) return 1
      val r = req[i-1]
      // r 为 i-1个排列要产生多少个逆序对
      // j 为 i个排列要产生多少个逆序对，j比r小可不行
      // i 前面总共有［0，i-1] i个数字，i个数字全部能与最后个数字产生逆序对，也就只有i个，
      // 而i-1要求r个，所以j>i+r也不行
      if(r!=-1 && (j<r || j-i>r)) return 0
      
      val key = i shl 16 or j
      if(key in d) return d[key]!!
      var ans = 0
      if(r==-1){
          for(k in 0..min(i,j)){
              ans = (ans + dfs(i-1,j-k,req))%MOD
          }
      }else{
          ans = dfs(i-1,req[i-1],req) % MOD
      }
      d[key]=ans
      return ans

  }
  fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
      val req = IntArray(n){-1}
      req[0]=0
      for((end,cnt) in requirements){
          req[end]=cnt
      }
      if(req[0]!=0)return 0
      return dfs(n-1,req[n-1],req)
  }
}