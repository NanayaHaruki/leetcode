class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices){
            if (i==0) ans[0]=nums[0]
            else ans[i]=nums[i]+ans[i-1]
        }
        return ans
    }
}