class Solution {
  fun minimumSum(n: Int, k: Int): Int {
      // 元素对之和不能等于k
      // 要求最终答案和最小，那当然选 [1,k/2]
      // 如果k/2 >=n 了，这就是答案，如果不够，那么[k/2,k]不能选了，需要从k+1开始往后补到n
      
      if(k/2>=n) {
          return (1+n)*n/2
      }
      return (1+k/2)*(k/2)/2 + (k+k+n-1-k/2)*(n-k/2)/2
  }
}