import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {


//        1516 4357 5949 7682
//        1516  2841 1592 1733 2317
    }

    static public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c != nums[0].length*nums.length) return nums;
        int[][] result = new int[r][c];
        int row = 0;int col = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
//                这两层for就在遍历所有元素了
                result[row][col] = nums[i][j];
                col++;
//                col为列数，存一个加一个；当加到c则换行，col归0
                if (col == c) {
                    row++;
                    col=0;
                }
            }
        }
        return result;
    }


    static void printArr(int[] nums) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
