class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(arr);
        System.out.println(i);
    }

    static public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length-1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int water = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(res, water);
            }
        }
        return res;
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
