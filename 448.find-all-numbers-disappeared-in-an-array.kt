/**
 *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and 
 * others appear once.                                                                                                                                                                              
 *Find all the elements of [1, n] inclusive that do not appear in this array.                                                                                                                       
 *Could you do it without extra space and in O(n) runtime? You may assume the returned list does not
 *count as extra space.                                                                                                                                                                               
 *Example:                                                                                                                                                                                            
 *Input:                                                                                            
 *[4,3,2,7,8,2,3,1]                                                                                 
 *                                                                                                  
 *Output:                                                                                           
 *[5,6] 
 * n为数组大小，数组里的数均为1..n  之间。如果有重复的数存在的话，就必然会有1..n区间内没有出现在数组的数，找出它们  
 *                                                                                            
*/
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        //[4.3.2.7.8.2.3.1]
        val ret = arrayListOf<Int>()  

        for (i in nums.indices) {
            val index = Math.abs(nums[i]) - 1
            if (nums[index] > 0) {
                nums[index] = -nums[index]
            }
            // println(nums.toList())
        }

        for (i in nums.indices) {
            if (nums[i] > 0) {
                ret.add(i + 1)
            }
        }
        return ret
    }
}
