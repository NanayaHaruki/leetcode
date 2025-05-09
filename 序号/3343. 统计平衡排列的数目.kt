class Solution {

  companion object{
      private const val MX = 41 // num最长80
      private const val MOD = 1000_000_007
      val fac = LongArray(MX).apply {
          this[0]=1
          for (i in 1 until MX) this[i] = this[i-1]*i% MOD
      }
      val invf = LongArray(MX).apply {
          this[lastIndex] = pow(fac.last(),MOD-2)
          for (i in MX-1 downTo 1){
              this[i-1]=this[i] * i % MOD
          }
      }

      private fun pow(base:Long,exponent:Int):Long{
          var ans = 1L
          var m = exponent
          var b = base
          while (m>0){
              if(m%2==1){
                  ans = ans * b % MOD
              }
              b = b*b% MOD
              m/=2
          }
          return ans
      }

  }
  fun countBalancedPermutations(num: String): Int {
      // 分2个组，每组n/2个，有（n/2)! * (n/2)! 种可能性。 再去重，1组中有2个1 ，3个2,答案要除2！* 3！
      // 计算0-9 有多少个，考虑几个i分到奇数索引组，
      val cnts = IntArray(10)
      var sm = 0
      for(x in num){
          cnts[x-'0']++
          sm+=x-'0'
      }
      if(sm%2!=0) return 0
      val n = num.length
      val pre = IntArray(10)
      pre[0]=cnts[0]
      for (i in 1 .. 9){
          pre[i]=pre[i-1]+cnts[i]
      }
      val mem = Array(10){Array(num.length/2+1){IntArray(sm/2+1){-1} }}
      fun dfs(i:Int,leftNum:Int,leftSum:Int):Int{
          // 选几个i，可以满足
          if(i<0){
              return if (leftSum==0) 1 else 0
          }
          if(mem[i][leftNum][leftSum]!=-1) return mem[i][leftNum][leftSum]
          val cnt = cnts[i]
          // 这cnt个i 多少个分到1组，多少个分到2组
          // 全给2组的时候，1组最少
          val left2 = pre[i]-leftNum
          var ans = 0L
          for (k in max(0,cnt-left2)..min(cnt,leftNum)){
              if (k*i>leftSum) break
              ans = (ans + dfs(i-1,leftNum-k,leftSum-k*i) * invf[k] % MOD * invf[cnt-k] % MOD)%MOD
          }
          return (ans % MOD).toInt().apply { mem[i][leftNum][leftSum]=this }

      }
      // dfs是用来去重的
      return (fac[n/2]*fac[n-n/2] % MOD * dfs(9,n/2,sm/2) % MOD).toInt()
  }
}