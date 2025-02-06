class Solution {
  fun permuteUnique(nums: IntArray): List<List<Int>> {
      val n = nums.size
      nums.sort()
      val vis = BooleanArray(n)
      val ans = mutableListOf<List<Int>>()
      val path = IntArray(n)
      fun dfs(i:Int){
          if (i==n){
              ans.add(path.toList())
              return
          }
          for (j in 0 until n){
              if (vis[j] || (j>0 && !vis[j-1] && nums[j]==nums[j-1]))
                  continue
              vis[j]=true
              path[i]=nums[j]
              dfs(i+1)
              vis[j]=false
          }
      }
      dfs(0)
      return ans
  }
}