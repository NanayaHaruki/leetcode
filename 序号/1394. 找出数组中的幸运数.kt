class Solution {
    fun findLucky(arr: IntArray): Int {
        val d = mutableMapOf<Int,Int>()
        arr.forEach{x-> d.merge(x,1,Int::plus)}
        var ans = -1
        for((k,v) in d){
            if(k==v && v>ans){
                ans=k
            }
        }
        return ans
    }
}