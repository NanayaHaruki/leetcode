// 删除掉数组中值为val的元素，返回删除后的数组长度，只能对数组本身进行操作，数组的前N个元素不能包括val
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
    	int n = nums.length;
    	while (i < n) {
        	if (nums[i] == val) {
            nums[i] = nums[n - 1];
            // reduce array size by one
            n--;
        	} else {
            i++;
        	}
    	}
    	return n;
    }
}

