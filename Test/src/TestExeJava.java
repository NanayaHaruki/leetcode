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
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,1,1};
        int res = distributeCandies(arr);
        System.out.println(res);
    }

    static public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int maxLen = 0;
        for(Map.Entry<Integer, Integer> entry : entries) {
            if (map.containsKey(entry.getKey() + 1)) {
                int tempMax = map.get(entry.getKey()) + map.get(entry.getKey() + 1);
                maxLen = Math.max(maxLen, tempMax);
            }
        }
        return maxLen;
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
