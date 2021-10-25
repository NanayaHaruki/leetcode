/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * @author:xzj
 * @date: 2018/9/4 9:30
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
//        nums是1~n的整数
        Arrays.sort(nums);
        int dup = -1, miss = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            //                重复的值找到了
            if (nums[i] == nums[i + 1]) dup = nums[i];
//            有重复的，就有少的那一个，这俩数中间的就是少的
            else if (nums[i] + 2 == nums[i + 1]) miss = nums[i] + 1;
        }
//        跑完一圈，不可能找不到重复的，但是有可能没找到缺失的，因为判断缺失的19行，数组最后一个数不会进来
//        数组最后一个数如果是数组长度，说明缺的是长度-1，比如5 7 缺6  ；如果不是，说明最后是6 6，缺7
        if (miss == -1) {
            int last = nums[nums.length - 1];
            if (last == nums.length) miss = 1;
            else if (last == nums.length - 1) miss = nums.length;
            else if (last == nums.length + 1) miss = nums.length - 1;
        }
        return new int[]{dup, miss};
    }
}

