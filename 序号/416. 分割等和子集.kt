class Solution {
    fun canPartition(nums: IntArray): Boolean {
        // 分割等和子集，就是背包，目的是拿一半
        val sm = nums.sum()
        if(sm.and(1)==1) return false
        val target = sm.shr(1)
        nums.sort()
        
        // i 最多100 ，remain最多10000
        val mem = mutableMapOf<Int,Boolean>()
        fun dfs(i:Int,remain:Int):Boolean{
            // 在[0,i]拿remain
            if (i<0 || remain<0) return false
            if(nums[i]==remain) return true
            val key = remain.shl(8).or(i)
            if(mem.contains(key)) return mem[key]!!
            return (dfs(i-1,remain) || dfs(i-1,remain-nums[i])).apply { mem[key]=this }
        }
        
        for (i in nums.size-1 downTo 0){
            if(dfs(i,target)) return true
        }
        return false
    }
}