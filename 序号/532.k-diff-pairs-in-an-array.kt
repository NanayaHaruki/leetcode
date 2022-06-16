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
    // 满足两数差值为k的数组对数量
    val n = nums.size;
    val set = mutableSetOf<String>()
    nums.sort()
    for (i in 1 until n) {
      for (j in 0 until i) {
        // 数组因为排序过，j为0差值最大，随j自增，差值变小，当小于k就不用继续检查了
        val diff = nums[i] - nums[j]
        if (diff == k) set.add("${nums[i]}_${nums[j]}")
        else if (diff < k) break
        else continue
      }
    }
    return set.size
  }
  
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
