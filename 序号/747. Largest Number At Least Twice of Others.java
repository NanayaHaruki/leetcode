/**
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * @author:xzj
 * @date: 2018/8/24 9:48
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int max1 = 0,max2 = 0,index=0;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if (num > max1) {
                max2 = max1;
                index = i;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return max1 >= 2*max2?index:-1;

    }

    fun dominantIndex(nums: IntArray): Int {
        var max = -1
        var preMax = -1
        var maxIndex = -1
        for (i in nums.indices){
            if (nums[i] > max) {
                preMax = max
                max = nums[i]
                maxIndex = i
            }else if (nums[i] > preMax) {
                preMax = nums[i]
            }
        }
        return if (max/2.0 >= preMax) maxIndex else -1
    }
}