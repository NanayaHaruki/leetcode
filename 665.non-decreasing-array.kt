/**
 *Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *We define an array is non-decreasing if array[i]  holds for every i (1
 *Example 1:
 *Input: [4,2,3]
 *Output: True
 *Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 *Example 2:
 *Input: [4,2,1]
 *Output: False
 *Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 * 能不能只改变数组中的一个值，使数组变成递增
 */
class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
    	// 如果大小是三个以下，肯定是符合条件的 [1,0]这种 改成[1,2]就是了
        if (nums.size < 3) return true
        // count记录前一位比后一位要大的情况，条件是递增，出现这种情况就要改动了，所以这种情况不能大于1次
        var count = 0
    	// index是出现前一位大于后一位的时候，后一位的角标
        var index = 1
        for (i in 1 until nums.size) {
            if (nums[i - 1] > nums[i]) {
                count++
                index = i
            }
        }
        return when (count) {
        	// 没有出现降序的情况
            0 -> true
            // 出现一次降序的情况 
            // 这里要排除掉[5,6,3,4]这种情况，nums[index]是3的话，前2位如果比index位置的数要大，就做不到只改一个数不降序
            // 既然有index，那么index-1的数必然是要大于index数的，但index-2的数却不能比index要大。如果是 3 6 3 4，只需改为3334即可
            // 同理，index前一位也不能比后一位要大。
            // index位于第二位和最后是特殊例子。 
            // 比如第二位  4 2 3 3  虽然index-1 大于index+1  但4前面没有数对他约束，所以改成2233即可
            // 倒数第二位 2342 改成2345即可
            1 -> index == 1
                    || index == nums.size - 1
                    || nums[index - 2] <= nums[index]
                    || nums[index - 1] <= nums[index + 1]
            // 降序出现1次以上肯定是不行的
            else -> false
        }
    }
}
