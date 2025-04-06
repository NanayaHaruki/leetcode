class Solution {

    fun largestDivisibleSubset(nums: IntArray): List<Int> {

        val n = nums.size
        val from = IntArray(n){-1} // 以i结尾最长由j来的，from[i]=j
        val mem = IntArray(n)
        nums.sort()

        fun dfs(i:Int):Int{
            // 以nums[i]结尾，最长多少
            if (mem[i]!=0) return mem[i]
            var mxLen = 0
            for(j in 0 until i){
                if (nums[i]%nums[j]==0){
                    val jLen = dfs(j)
                    if(jLen>mxLen) {
                        mxLen=jLen
                        from[i]=j
                    }
                }
            }
            return (mxLen+1).apply { mem[i]=this }
        }
        // 让每个数都作为最后一个点，找最长的
        var mxLen = 0
        var lastIdx = -1
        for (i in 0 until n){
            val len = dfs(i)
            if(len>mxLen){
                mxLen=len
                lastIdx=i
            }
        }
        // 现在知道最长的序列，最后个索引是lastIdx，根据from记录创建答案
        val ans = mutableListOf<Int>()
        while (lastIdx>=0){
            ans.add(nums[lastIdx])
            lastIdx=from[lastIdx]
        }
        return ans
    }
}