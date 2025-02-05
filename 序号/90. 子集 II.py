class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        val n = nums.size
        val  path = mutableListOf<Int>()
        fun dfs(i:Int){
            if (i==n) {
                ans.add(path.toList())
                return
            }
            path.add(nums[i])
            dfs(i+1)
            path.removeAt(path.lastIndex)
            
            val x = nums[i]
            var j = i+1
            while (j<n && nums[j]==x) ++j
            dfs(j)
        }
        dfs(0)
        return ans.toList()
    }
}