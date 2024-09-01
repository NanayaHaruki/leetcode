class Solution {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        // 区间修改 单点查询，用差分，再用前缀和
        val f = IntArray(1002)
        for(start in startTime){
            f[start]++
        }
        for(end in endTime){
            f[end+1]--
        }
        for(i in 1 until 1002){
            f[i]+=f[i-1]
        }
        return f[queryTime]
    }
}