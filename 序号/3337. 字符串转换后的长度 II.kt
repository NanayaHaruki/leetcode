class Solution {
  fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
      // f[i][0] 为 a转换i次后的长度 ，f[0][0]~f[0][25]表示不转换，那26个字母都应该是1
      // f[1][0] 为 a 转换1次的长度，这取决于nums[0]， nums[0]若为2，a转换为bc，f[1][0]为2
      // f[t][c] = f[t-1][c+1]+f[t-1][c+2]+...+f[t-1][c+nums[c-'a']]
      // 可以将连加转换为矩阵乘法
      // f[t][0] = [...][f[t-1][0]
      // f[t][1] = [...][f[t-1][1]
      // f[t]=M * F[t-1] = M * M * F[t-2] = M^t * F[0]
      // 求一个字符转换t次后的长度，只要计算M这个矩阵的t次幂即可
      val f = Array(26){ intArrayOf(1) }
      val m = Array(26){IntArray(26)}.apply {
          for(i in 0..25){ // i 为矩阵的行，表达某个字符能转换成什么其他字符
              for(j in i+1..nums[i]+i){
                  this[i][j%26]=1
              }
          }
      }
      val mod = 1_000_000_007
      fun mul(a:Array<IntArray>,b:Array<IntArray>):Array<IntArray>{
          // 矩阵相乘
          val ans = Array(a.size){IntArray(b.size)}
          for(i in a.indices){
              for(j in a[i].indices){
                  if (a[i][j]==0) continue
                  for (k in b[j].indices){
                      ans[i][k] = ((ans[i][k] + 1L*a[i][j]*b[j][k]) % mod).toInt()
                  }
              }
          }
          return ans
      }
      fun powMul(a:Array<IntArray>,t:Int):Array<IntArray>{
          var ans = f
          var n = t
          var base = a
          while(n>0){
              if(n.and(1)==1) ans=mul(base,ans)
              n/=2
              base=mul(base,base)
          }
          return ans
      }
      val cnts = IntArray(26).apply {
          for(c in s) this[c-'a']++
      }
      var ans = 0L
      val mt = powMul(m,t)
      for(i in 0..25){
          ans = (ans + 1L*mt[i][0] * cnts[i])%mod
      }
      return ans.toInt()
  }
}