class Solution {
  fun nonSpecialCount(l: Int, r: Int): Int {
      val primes = sieveOfEratosthenes(sqrt(r.toDouble()).toInt())
      var cnt = 0
      for (p in primes) if (p * p in l .. r) cnt++
      return r - l + 1 - cnt
  }

  private fun sieveOfEratosthenes(n: Int): List<Int> {
      val isPrime = BooleanArray(n + 1) { true }
      isPrime[0] = false
      isPrime[1] = false

      for (p in 2..Math.sqrt(n.toDouble()).toInt()) {
          if (isPrime[p]) {
              for (i in p * p..n step p) {
                  isPrime[i] = false
              }
          }
      }

      val primes = mutableListOf<Int>()
      for (i in 2..n) {
          if (isPrime[i]) {
              primes.add(i)
          }
      }

      return primes
  }
}