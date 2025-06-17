class Solution {
  companion object {
      const val MX = 1_00_000
      const val MOD = 1_000_000_007
      val fac = LongArray(MX + 1).apply {
          this[0] = 1
          for (i in 1..MX) this[i] = this[i - 1] * i % MOD
      }

      fun qpow(_b: Long, _n: Int): Long {
          var n = _n
          var b = _b
          var ans = 1L
          while (n > 0) {
              if (n.and(1) == 1) ans = ans * b % MOD
              b = b * b % MOD
              n /= 2
          }
          return ans
      }

      val inv_f = LongArray(MX + 1).apply {
          this[MX] = qpow(fac[MX], MOD - 2)
          for (i in MX downTo 1) {
              this[i - 1] = this[i] * i % MOD
          }
      }

      fun c(m: Int, n: Int): Long {
          return fac[m] * inv_f[n] % MOD * inv_f[m - n] % MOD
      }

  }

  fun countGoodArrays(n: Int, m: Int, k: Int): Int {
      // n个数，大小在[1,m]，有k对相邻数相同，有多少种组合
      // 隔板法，n个数有n-1对，k对相同，就有n-1-k对不同，在不同的数之间加隔板有多少种隔法：C(n-1,n-1-k)，n-1-k个隔板隔出n-k个子数组
      // 隔板隔开内部都是相同的数，第1组在m中任意选，后面n-k-1 组不能与前一组相同，有m-1种。
      return (c(n - 1, n - 1 - k) * m % MOD * qpow((m - 1).toLong(), n - k - 1) % MOD).toInt()
  }
}