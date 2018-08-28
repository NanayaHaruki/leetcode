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
    }

    static public int numberOfBoomerangs(int[][] points) {
//        存储两点距离出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = gougu(points[i][0] - points[j][0], points[i][1] - points[j][1]);
//                    这个距离出现过，+1，没出现存1
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for(Integer count : map.values()) {
//                某个距离出现过count次，取出一种可能性，回旋镖 A B放好，再取出一种可能性C 1(count-1) ,回旋镖放好 A B C
                result += count * (count - 1);
            }
            map.clear();
        }
        return result;
    }

    static int gougu(int x, int y) {
        return x*x+y*y;
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
