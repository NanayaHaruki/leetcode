fun countDigitOne(n: Int): Int {
  // 10^k 位上1的个数位 n/10+min（100，max（n'-99）
  var k = 1L
  var ans = 0L
  while (k<=n){
    ans+= n/(k*10)*k+ minOf(k, maxOf(n%(k*10)-k+1,0))
    k*=10
  }
  return ans.toInt()
}