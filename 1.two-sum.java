// 给一个数组，找出两个元素相加=target，返回两个元素的角标
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key放值，value放角标
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
//            拿到target-当前遍历到的值
            int j = target - nums[i];
//            如果曾经加入过map中，那么直接返回
            if (map.containsKey(j)) {
                return new int[]{map.get(j),i};
            }
//            否则将当前遍历值加入集合
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("");
    }
}

