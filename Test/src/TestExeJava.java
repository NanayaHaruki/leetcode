import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,1,1};
        int res = distributeCandies(arr);
        System.out.println(res);
    }

    static public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = candies.length>>1; //平分，每人一半
        for(int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
//        糖果种类 小于 持有数，女孩可以每样拿一个，把种类拿全；
        if(map.size()<=sum) return map.size();
//        通过种类数比较多，sum有多少就有多少种
        else return sum;

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
