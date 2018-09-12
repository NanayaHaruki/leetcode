class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    static public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
//        老实说我不太懂这题的意思
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        throw new RuntimeException("给的数组有问题");
    }


    static int discovery(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  //递归超出范围
                || grid[i][j] == -1 //-1说明这块区域已经探索过了
                || grid[i][j] == 0) { //0就中止探索
            return 0;
        }
        grid[i][j] = -1;
        return 1 + discovery(grid, i - 1, j) + discovery(grid, i + 1, j) + discovery(grid, i, j + 1) + discovery(grid, i, j - 1);
    }


}
