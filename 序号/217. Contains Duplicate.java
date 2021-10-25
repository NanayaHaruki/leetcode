/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * @author:xzj
 * @date: 2018/7/31 11:29
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for(int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
}
