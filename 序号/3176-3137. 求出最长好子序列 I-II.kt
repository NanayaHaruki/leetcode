class Solution {
  fun maximumLength(nums: IntArray, k: Int): Int {
      // 定义f[x][j] 为以x结尾，有j个相邻相等的子序列最大长度
      // 1. 之前也是x结尾的，f[x][j]++
      // 2. 之前是别的数y结尾，现在以x结尾，答案为 f[y][j-1]+1
      //    因为f[x][j-1] 必定不会大于 f[x][j]，所以不用考虑x与y相等问题
      val f = mutableMapOf<Int,IntArray>()
      val mx = IntArray(k+1)
      for(x in nums){
          if(!f.contains(x))
              f[x]=IntArray(k+1)
      }
      for(x in nums){
          for(j in k downTo 0){
              f[x]!![j]=max(f[x]!![j],if(j>0) mx[j-1] else 0)+1
              mx[j]=max(mx[j],f[x]!![j])
          }
      }
      return mx.last()
  }
}