/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * @author:xzj
 * @date: 2018/7/31 14:03
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            for(int j = 0; j < k; j++) {
                if(i+j+1 > nums.length-1) break;
                if (nums[i] == nums[i + j + 1]) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
