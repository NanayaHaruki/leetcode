/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *Example 1:
 *
 *Input: [1, 2, 2, 3, 1]
 *Output: 2
 *Explanation:
 *The input array has a degree of 2 because both elements 1 and 2 appear twice.
 *Of the subarrays that have the same degree:
 *[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 *The shortest length is 2. So return 2.
 *Example 2:
 *Input: [1,2,2,3,1,4,2]
 *Output: 6
 *
 * 求出最小区间的数组 与原数组的层级相同
 */
class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
    	// key为nums中的值，value为一个数组，
        // 数组第一个位置放初始角标，第二个位置放最后出现的角标，第三个位置是出现次数
        val map = mutableMapOf<Int, IntArray>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val intArr = map[nums[i]]
                intArr!![1] = i
                intArr[2] = intArr[2] + 1
            } else {
                // 第一次存进去，初始角标是i，最大角标暂时为0，出现次数1
                map.put(nums[i], intArrayOf(i, 0, 1))
            }
        }

//        max表示出现次数，至少出现两次才往集合里面放。如果只出现一次会出现lastIndex无法赋值的情况
        var max = 2
        val maxList = mutableListOf<Int>()
        for (entry in map) {
            if (entry.value[2] > max) {
//                如果有出现次数更多的，清空集合，存进去最新的最大区间
                maxList.clear()
                maxList.add(entry.value[1] - entry.value[0])
                max = entry.value[2]
            } else if (entry.value[2] == max) {
//                可能会有出现次数相同的，我们要找出其中最小的区间
                maxList.add(entry.value[1] - entry.value[0])
            }
        }

        return if (nums.isEmpty())  0
        else (maxList.min() ?: 0) + 1
    }
}
