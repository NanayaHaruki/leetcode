class Solution() {
  fun constructArray(n: Int, k: Int): IntArray {
    // 返回相邻两个数的间距有k个数
    val ans = IntArray(n)
    var i= 0
    var low = 1
    var high = 1+k
    while (i<=k){
      if (i%2==0) ans[i++]=low++
      else ans[i++]=high--
    }
    high = k+2
    while (i<n){
      ans[i++]= high++
    }
    return ans
  }
}