/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author:xzj
 * @date: 2018/8/28 16:11
 */
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) return nums[0];
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) return nums[i];
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
            }
        }
        return 0;
    }
}
