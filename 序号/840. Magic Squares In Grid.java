/**
 *3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 *
 * 1 <= grid.length = grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * @author:xzj
 * @date: 2018/8/28 9:02
 */
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        if(grid.length < 3 || grid[0].length < 3) return 0;
        for(int i = 0; i <= grid.length-3; i++) {
            for(int j = 0; j <= grid[0].length-3; j++) {
                if(check(grid[i][j],grid[i][j+1],grid[i][j+2],
                        grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2],
                        grid[i+2][j],grid[i+2][j+1],grid[i+2][j+2])) result++;
            }
        }
        return result;
    }

    boolean check(int...args){
        if(args[4]!=5) return false;
//        args的值为0~15，0就count[0]+1。数数看每个数字出现的个数。
//        只有1~9角标的值都是1，其他为0，才可能是幻方。
        int[] count = new int[16];
        for(int arg : args) {
            count[arg]++;
        }
//        只需判断1~9即可，只有9个数，这9个为1，其他的是多少不用关心
        for(int i = 1; i <= 9; i++) {
            if(count[i]!=1) return false;
        }
        return args[0]+args[1]+args[2] ==15 &&
                args[3]+args[4]+args[5] ==15 &&
                args[6]+args[7]+args[8] ==15 &&
                args[0]+args[3]+args[6] ==15 &&
                args[1]+args[4]+args[7] ==15 &&
                args[2]+args[5]+args[8] ==15 &&
                args[0]+args[4]+args[8] ==15 &&
                args[2]+args[4]+args[6] ==15;
    }
}
