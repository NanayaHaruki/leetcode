class Solution {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val n = nums.size
        if(n%2==1) return false // 总数不能是奇数
        val d = mutableMapOf<Int,Int>()
        for(x in nums){
            val cnt = d.getOrDefault(x,0)
            if(cnt==2) return false
            d[x]=cnt+1
        }
        return true
    }
}