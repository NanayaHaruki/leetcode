/**
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
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ;i<nums.length;i++) {
        	// 数组里的数-1 就是角标。根据这个角标找数，设为相反数。
        	// 遍历一遍后，数组中还为正的数就是没有被对应角标改动过的。
        	// +1即为原数组没有的数
        	int index = Math.abs(nums[i]) - 1;
        	if(nums[index] > 0) {
        		nums[index] = - nums[index];
        	}
        }
        List<Integer> result = new ArrayList<>();
        for(int j = 0 ; j < nums.length; j++) {
        	if(nums[j] > 0) {
        		result.add(j+1);
        	}
        }
        return result;
    }
}
