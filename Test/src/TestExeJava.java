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
    public static void main(String[] args)

    {

        int[] arr = {-1,-1,-1,-1,-1,0};
        int oneBitCharacter = pivotIndex(arr);
        System.out.println(oneBitCharacter);
    }

    static public int pivotIndex(int[] nums) {
        int sum = 0,leftSum = 0;
        for(int num : nums) sum+=num;
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
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
