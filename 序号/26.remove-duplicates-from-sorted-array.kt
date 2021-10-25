class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for(i in 1 until nums.size){
        	if(nums[i] > nums[index]) {
        		nums[++index] = nums[i]
        	}
        }
        return index+1
    }
}
