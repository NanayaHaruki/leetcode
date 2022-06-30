fun numPrimeArrangements(n: Int): Int {
  // 排列方式数量 就是阶乘，本题转化为 质数数量的阶乘 * 合数数量的阶乘
  val mod = (1e9 + 7).toInt()
  val a = countPrime(n);
  val b = n - a;
  var ans = 1L
  for (i in 1..a) ans = ans * i % mod
  for (i in 1..b) ans = ans * i % mod
  return ans.toInt()
}

fun countPrime(n: Int): Int {
  val primes = mutableListOf<Int>()
  val isPrime = BitSet()
  isPrime.set(2, n + 1)
  for (i in 2..n) {
    if (isPrime[i]) primes.add(i)
    var j = 0
    while (j < primes.size && primes[j] * i <= n) {
      isPrime.clear(i * primes[j])
      if (i % primes[j] == 0) break
      j++
    }
  }
  return primes.size
}