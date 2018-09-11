class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            double pow = Math.pow(3, i);
        }
    }

    static public boolean isPowerOfThree(int n) {
//        逢3进位，3的幂必然是 10  100 1000 10000这种
       return Integer.toString(n,3).matches("10*");
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
