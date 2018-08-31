/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * @author:xzj
 * @date: 2018/8/31 9:05
 */
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int maxLen = 0;
        for(Map.Entry<Integer, Integer> entry : entries) {
            if (map.containsKey(entry.getKey() + 1)) {
                int tempMax = map.get(entry.getKey()) + map.get(entry.getKey() + 1);
                maxLen = Math.max(maxLen, tempMax);
            }
        }
        return maxLen;
    }
}
