/**
 *Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *Example 1:
 *Input: [1,4,3,2]
 *Output: 4
 *Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 *数组的数量是2n，把数组分成n对，把每一对的小的加起来，求这个最大的可能值
 */
class Solution {
	// 假设b>a
	// Smax = min(a1,b1) + min(a2,b2) +...+min(an,bn) = a1+a2+...+an  Smax是我们求的解
	// sum = a1+b1+a2+b2+...an+bn    sum是数组的和，是一个常量
	// Sdiff = b1-a1 + b2 - a2 + ...+ bn - an   每一对差分相加
	// sum - Sdiff = 2Smax => sum是常量，想要Smax最大，就要Sdiff尽可能的小

	// 举例 1234  
	// 分成(1,2)(3,4) Sdiff = 1+1=2
	// (1,3)(2,4) Sdiff = 2+2 = 4
	// (1,4)(2,3) Sdiff = 3+1 = 4
	// 可以看出让数组升序排列，按顺序分组所得Sdiff为最小值。

	// Smax = nums[1] + nums[2] + ... + nums[n]
    fun arrayPairSum(nums: IntArray): Int {
     	nums.sort()
     	var max = 0
     	for(i in nums.indices step 2) {
     		max += nums[i]
     	}   
     	return max
    }
}
