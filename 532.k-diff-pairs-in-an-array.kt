/**
 *Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *Example 1:
 *Input: [3, 1, 4, 1, 5], k = 2
 *Output: 2
 *Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * k为差值  在数组中找出该差值的对子数量
 * 3 1 4 1 5   k为2的对子有1,3   3,5   两个，所以返回2
 * 对子有唯一约束性 (1,3) (3,1) 是同一个   数组里有多个1和多个3  都只能算一个
 */
class Solution {
   fun findPairs(nums: IntArray, k: Int): Int {
        //因为对子有唯一约束性，所以弄个set存起来防止重复
        val set = mutableSetOf<Int>()
        nums.sort()
        val maxIndex = nums.size -1
        for(i in nums.indices) {
            var rightIndex = i
            while(true) {
                rightIndex++
                if(rightIndex > maxIndex) break
                if(nums[rightIndex] - nums[i] == k) {
                    set.add(nums[i])
                }
                else if(nums[rightIndex] - nums[i] < k) continue
                else break
            }
        }
        return set.size
    }
}
