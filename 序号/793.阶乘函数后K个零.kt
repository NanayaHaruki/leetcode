class Solution {
  fun preimageSizeFZF(k: Int): Int {
    // 阶乘有k个后缀0的数有几个
    // 0-4  末尾0个0
    // 5-9  末尾1个0
    // 10-99    末尾2个0
    /** n的阶乘后缀0个数 */
    fun zeta(n:Long):Long{
      var N = n
      var ans = 0L
      while(N>0){
        N/=5
        ans+=N
      }
      return ans
    }
    
    fun binarySearch(k:Int):Long{
      var l = 0L;var r = (1e10).toLong()
      while(l<=r){
        val m = l+(r-l)/2
        val cnt = zeta(m)
        if(cnt>= k) r=m-1
        else l=m+1
      }
      return l
    }
    return (binarySearch(k+1)-binarySearch(k)).toInt()
  }
}