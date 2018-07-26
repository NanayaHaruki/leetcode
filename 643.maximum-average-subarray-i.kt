/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 给一个数组，给一个范围，求出连续区间内平均值最大值
 */
class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
    	if(nums.isEmpty() || k==0) return 0.0
        var maxSum = Int.MIN_VALUE
        return if(nums.size >= k) {
//            k为4的话，i应该从3开始往后数，第一个求出的和 应该是角标0,1,2,3的和
            for(i in k-1 until nums.size) {
                var sum = 0
//                求和为i角标的自己 再往前数k-1个数
                for (j in 0 until k) {
                    sum+=nums[i-j]
                }
                if(sum>maxSum) maxSum = sum
            }
            maxSum.toDouble()/k
        }else {
            nums.forEach {
                maxSum+=it
            }
            maxSum.toDouble()/nums.size
        }
    }
}
