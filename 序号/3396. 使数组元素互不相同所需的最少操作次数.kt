class Solution {
    fun minimumOperations(nums: IntArray): Int {
        // 统计每个数字的数量，删一次后，看下字典大小与剩余数量是否一致，一致就是每个数字一个
        val m = mutableMapOf<Int,Int>()
        for(x in nums){
            m[x]=(m[x]?:0)+1
        }
        var n = nums.size
        if(m.size==n) return 0
        var cnt = 0
        for(i in 0 until n-2 step 3){
            for(j in i..i+2){
                m.computeIfPresent(nums[j]){_,v->
                    if(v==1) null
                    else v-1
                }
            }
            n-=3
            ++cnt
            if(m.size==n) return cnt
        }
        return cnt+1
    }
}