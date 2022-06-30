fun countPrimes(n: Int): Int {
  // 计算小于n的质数数量,线性筛
  // 从2～n-1遍历， 质数加紧答案，遍历质数集合，数与质数的积为合数，打上标记，如果质数为该数的因数，退出内循环，每个合数都会被最小质因数筛掉。
  val primes = mutableListOf<Int>()
  val isPrime = BitSet()
  isPrime.set(2,n,true)
  for (i in 2 until n){
    if (isPrime[i]) primes.add(i)
    var j = 0
    while (j<primes.size && primes[j]*i<n){
      isPrime.set(i*primes[j],false)
      if (i%primes[j]==0) break
      j++
    }
  }
  return primes.size
}