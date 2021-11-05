class Solution {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        // 最长定差子序列
        val dict = mutableMapOf<Int,Int>() // 记录已key为结尾的子序列长度为value
        var ans = 1
        for (i in arr){
            dict[i]=(dict[i-difference]?:0)+1
            ans = maxOf(ans,dict[i]!!)
        }
        return ans
    }
}