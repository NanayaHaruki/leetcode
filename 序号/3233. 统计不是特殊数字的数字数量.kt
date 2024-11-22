class Solution {
  
  val primes = mutableListOf<Int>()
  init {
    val n = sqrt(1e9).toInt()
    val isPrimes = BooleanArray(n+1){true}
    for (i in 2..n){
      if (isPrimes[i]) primes.add(i)
      for(j in primes){
        if(i*j>n) break
        isPrimes[i*j]=false
        if (i%j==0) break
      }
    }
  }
  
  fun less(x:Int):Int{
    var l = -1
    var r = primes.size
    var m = 0
    while(l+1<r){
      m = (l+r)/2
      if(primes[m]*primes[m]<=x){
        l=m
      }else{
        r=m
      }
    }
    return l
  }
  fun greater(x:Int):Int{
    var l = -1
    var r = primes.size
    var m = 0
    while(l+1<r){
      m = (l+r)/2
      if(primes[m]*primes[m]<x){
        l=m
      }else{
        r=m
      }
    }
    return r
  }
  fun nonSpecialCount(l: Int, r: Int): Int {
    // 符合条件的只能是平方数
    return r-l+1-(less(r)-greater(l)+1)
  }

}