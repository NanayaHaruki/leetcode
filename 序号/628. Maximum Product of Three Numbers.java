/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @author:xzj
 * @date: 2018/8/6 17:12
 */
class Solution {
    public int maximumProduct(int[] nums) {
//        三数最大乘积，必然要乘上最大的数。
//        另两个数要么是最小的两个负数，要么是第2、3大的数
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],
                nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
