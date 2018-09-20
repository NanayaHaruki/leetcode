import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.A;

class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {3,5,2,1,4,7,8};
        int[] ints = sortArrayByParity(arr);
        for(int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i : A) {
            if(i%2==0) even.add(i);
            else odd.add(i);
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(even);
        res.addAll(odd);
        return res.stream().mapToInt(Integer::intValue).toArray();
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
