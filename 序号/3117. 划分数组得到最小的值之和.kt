class Solution {

  fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
      // 将nums分段，每段的与值=andValues,求每段最后一个数的值的和的最小值
      val m = andValues.size
      val n = nums.size
      val mem= mutableMapOf<Int,Int>()
      fun dfs(i: Int, j: Int, _and: Int): Int {
          // 每段一个数都不够分了
          if (n - i < m - j) return Int.MAX_VALUE/2
          // andValues分完了，如果nums也刚好分完，符合要求，返回0不影响最终求和
          if (j == m) {
              return if (i == n) 0 else Int.MAX_VALUE/2
          }
          // val k = "$i-$j-$_and"
          // m最长为10，4bit就够放; n最多1e4，每个数都是一万以内，与值也在一万以内,n和and各需要14位
          // 刚好够32位
          val k = (_and shl 18) or (i shl 4) or j

          if (k in mem) {
            return mem[k]!!
          }
            
            
          val new_and = _and and nums[i]
          var ans = dfs(i+1,j,new_and)
          
          if (new_and==andValues[j]){ // 可以在这分段
          
            ans = min(ans,dfs(i+1,j+1,-1)+nums[i])
           
          }
          
          mem[k]=ans
          return ans
      }
      val ans = dfs(0,0,-1)
      return  if(ans < Int.MAX_VALUE/2) ans else -1
  }
}