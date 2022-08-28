class Solution {
  fun trailingZeroes(n: Int): Int {
    // 1-n 中有多少个质因数5
    var ans = 0
    var N = n
    while(N>0){
      N/=5
      ans+=N
    }
    return ans
  }
}