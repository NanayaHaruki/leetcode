/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author:xzj
 * @date: 2018/8/1 9:41
 */

class Solution {
    public void moveZeroes(int[] nums) {
//        基本就是冒泡的思路，碰到0往后挪
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                for(int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums,i,j);
                        for(int k = j; k < nums.length-1; k++) {
                            swap(nums,k,k+1);
                        }
                        break;
                    }
                }
            }
        }
    }
}
