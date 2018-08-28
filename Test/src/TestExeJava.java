import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
//         [[4,3,8,4],
// *       [9,5,1,9],
// *       [2,7,6,2]]
       int[][] arr = {{4,3,8,4},
                      {9,5,1,9},
                      {2,7,6,2}};
        System.out.println(numMagicSquaresInside(arr));
    }

    static public int numMagicSquaresInside(int[][] grid) {
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

    static boolean check(int...args){
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
