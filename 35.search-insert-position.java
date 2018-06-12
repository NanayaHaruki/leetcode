// 给一个排序数组，找到target所在角标，如果没有，找到他应该插入的角标
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
        	if(nums[i]>=target) return i;
        }
        return nums.length;
    }
}

