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
        int[] ints = fairCandySwap(new int[]{1,2,5}, new int[]{2, 4});
        for(int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static public int[] fairCandySwap(int[] A, int[] B) {
//      交换后俩人总量相等，交换后没人的总量就是两人加起来除2
        int sumA=0,sumB = 0;
        for(int i : A) sumA+=i;
        for(int i : B) sumB+=i;
//        sum为交换后每人的总量
        int sum = (sumA+sumB)>>1;
        int diff = sumA - sum;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(A[i] - B[j] == diff) return new int[]{A[i], B[j]};
            }
        }
        return new int[2];
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
