class NumArray {
	int[] items;
    public NumArray(int[] nums) {
        items = nums;
        if(items.length>1) {
            for(int i = 1; i < items.length; i++) {
//            将每个角标的值变更成前面所有角标的和
//            因为题目是求i ~ j之间数的和，所以循环报完后，只要一减就行了，不需要跑N次循环
                items[i] += items[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i==0) return items[j];
        return items[j] - items[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

