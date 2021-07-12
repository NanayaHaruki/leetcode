class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var sum = 0
        val map = mutableMapOf<Int,Int>()
        map[0]=1
        var ans =0
        for (i in nums.indices){
            sum+=nums[i]
            val preCnt = map.getOrDefault(sum-k,0) //之前存过的符合要求的前缀和有几个
            ans+=preCnt
            map[sum]=map.getOrDefault(sum,0)+1
        }
        return ans
    }
}