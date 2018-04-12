
/**
 *Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *You need to find the shortest such subarray and output its length.
 *Example 1:
 *Input: [2, 6, 4, 8, 10, 9, 15]
 *Output: 5
 *Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *找出一个区间做升序，使可以让整个数组变成升序，求最小区间的长度
 */
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var maxIndex = nums.size-1
        var start = -1 
        var end = -1
        var min = nums[maxIndex]
        var max = nums[0]
        for(i in 1..maxIndex) {
        	// 从左往右找最大值
        	max = Math.max(max,nums[i])
        	// 从右往左找最小值
        	min = Math.min(min,nums[maxIndex - i])
        	// 从左向右，第一次出现比左边要小的数时，开始给end赋值。若一直没有出现更大的数，则end随i递增。
        	// 出现更大的数后，max重新被赋值，后面如果数组递增，end不会再次被赋值。如果又出现了递减，则end变更
        	if(nums[i] < max) end = i

        	// 反向同理
        	if(nums[maxIndex-i] > min) start = maxIndex - i
        }
    	// 没有被赋值，说明整个数组已经是升序状态了
    	if(start == -1) return 0
    	return end - start +1
    }
}
