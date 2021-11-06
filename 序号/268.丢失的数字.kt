class Solution {
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        var ans = nums.size
        for(i in nums.indices){
            if(i!=nums[i]){
                ans=i
                break
            }
        }
        return ans
    }
}