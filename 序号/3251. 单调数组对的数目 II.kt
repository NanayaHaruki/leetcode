class Solution {
  val mx = 3001
  val f = LongArray(mx) // f[i]就是i的阶乘
  val invF = LongArray(mx) // invF[i] 是 i!^-1,乘这个数就相当于除了i！
  val mod = 1000000007
  init{
      f[0]=1
      for (i in 1 until mx){
          f[i]=i*f[i-1]%mod
      }
      invF[mx-1]=qpow(f[mx-1],mod-2)
      for (i in mx-1 downTo 1){
          invF[i-1]=invF[i]*i%mod
      }
  }

  fun countOfPairs(nums: IntArray): Int {
      val n = nums.size
      var m = nums.last()
      for (i in 1 until n){
          m-= max(0,nums[i]-nums[i-1])
          if(m<0) return  0
      }
      return comb(m+n,n)
  }

  private fun comb(m:Int,n:Int):Int{
      // 组合c(m,n)=m!/(n! * (m-n)!)=m! / n! / (m-n)!
      // 除法取模 a/b % mod = a * pow(b,mod-2) % mod
      return (f[m]*invF[n]%mod*invF[m-n]%mod).toInt()
  }
  
  private fun qpow(_x:Long,_n:Int):Long{
      var n = _n
      var x = _x
      var ans = 1L
      while (n>0){
          if(n%2==1){
              ans = ans * x % mod
          }
          x = x*x%mod
          n/=2
      }
      return ans
  }
}