/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 时间O(n)
 * 空间O(1)
 * @author:xzj
 * @date: 2018/7/31 14:24
 */

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
//        那么排序之后，值应该等于角标；数组必定缺一位，所以最后一位不是length-1，而是length，
//        如果不是length，那么说明前面都没缺，缺的就只能是最后一位了。 即0 1 2 3  那缺的是4
        if(nums[nums.length-1]!=nums.length) return nums.length;
        else if (nums[0] != 0) return 0;
        for(int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
