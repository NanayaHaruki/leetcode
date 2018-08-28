import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        System.out.println(wordPattern("abbc","cat dog dog cat1"));
    }

    static public boolean wordPattern(String pattern, String str) {
        String regex = " ";
        String[] arr = str.split(regex);
        if(pattern.length() != arr.length) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String valueStr = map.get(c);
                if (!arr[i].equals(valueStr)) return false;
            }else {
//                不包含这个key，却包含value，说明别的key对应了value，不匹配
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            }
        }
        return true;
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
