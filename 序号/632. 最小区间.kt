class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        // 每个组至少一个数字，先排序
        val groups = nums.flatMapIndexed { index: Int, ints: List<Int> -> ints.map { intArrayOf(it,index) } }.sortedBy { it[0] }
        var l=0
        var r = 0
        val n = nums.size
        val cnts=IntArray(n) // 包含[L,R]中包含哪些位置的组
        var groupCnt = 0 // 不同的组有几个
        val ans = IntArray(2)
        var diff = Int.MAX_VALUE
        while (r<groups.size){
            cnts[groups[r][1]]++
            if(cnts[groups[r][1]]==1){
                groupCnt++
            }
            while (groupCnt==n){ // 更新答案
                val curDiff = groups[r][0]-groups[l][0]
                if (curDiff<diff || (curDiff==diff && groups[l][0]<ans[0])){
                    ans[0]=groups[l][0]
                    ans[1]=groups[r][0]
                    diff = curDiff
                }
                l++
                cnts[groups[l-1][1]]--
                if (cnts[groups[l-1][1]]==0) groupCnt--

            }
            r++
        }
        return ans
    }
}