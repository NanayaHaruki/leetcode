class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        // 前缀和计算 遍历到index时，sum(0..index) -  sum(i) = goal,
        // 因为是二元数组，有很多0,所以这个i有多少个，答案就要加上多少个
        var sum = 0
        var ans = 0
        val preMap = mutableMapOf<Int,Int>() // 记录某个前缀和出现的次数
        preMap[0] = 1
        for(num in nums){
            sum+=num
            val cnt = preMap.getOrDefault(sum-goal,0)
            ans+=cnt
            preMap[sum]=preMap.getOrDefault(sum,0)+1
        }
        return ans
    }
}