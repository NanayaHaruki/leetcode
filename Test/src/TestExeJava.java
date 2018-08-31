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
      String[] list1 =  {"Shogun", "Tapioca Express", "Burger King", "KFC"};
      String[] list2 =  {"KFC", "Shogun", "Burger King"};
        String[] restaurant = findRestaurant(list1, list2);
        for(String s : restaurant) {
            System.out.println(s);
        }
    }

    static public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = 0;
        Map<String, Integer> map = new HashMap<>();//key存餐厅名称，value存角标
        TreeMap<Integer, ArrayList<String>> ts = new TreeMap<>();
        for(int i = 0; i < list1.length; i++)  map.put(list1[i], i);
        for(int i = 0; i < list2.length; i++) {
//            找list1中有无这个餐厅
            Integer list1Index = map.get(list2[i]);
            if (list1Index != null) {
//                找到了，存进index
                ArrayList<String> nameList = ts.getOrDefault(list1Index + i, new ArrayList<>());
                nameList.add(list2[i]);
                ts.put(list1Index + i, nameList);
            }
        }
//        treeMap会自然排序，第一个自然是最小索引
        if(ts.size()==0) return new String[]{};
        ArrayList<String> value = ts.firstEntry().getValue();
        return  value.toArray(new String[0]);
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
