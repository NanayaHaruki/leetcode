class NumArray {
	int[] items;
    public NumArray(int[] nums) {
        items = nums;
    }

    public int sumRange(int i, int j) {
        if (items == null) return 0;
        if (i >= items.length || i< 0 || j<0 || j >= items.length) return 0;

        int sum = 0;
        while (i <= j) {
            sum+=items[i];
            i++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

