import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        for(String s : uncommonFromSentences("this is a apple", "this is a banana")) {
            System.out.println(s);
        }
    }

    static public String[] uncommonFromSentences(String A, String B) {
        String regex = " ";
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> mapA = new HashMap<>();
        HashMap<String, Integer> mapB = new HashMap<>();
        for(String s : A.split(regex)) mapA.put(s,mapA.getOrDefault(s,0)+1);
        for(String s : B.split(regex)) mapB.put(s,mapB.getOrDefault(s,0)+1);
        mapA.forEach((s, integer) -> {
            if(integer == 1 && !mapB.containsKey(s)) res.add(s);
        });
        mapB.forEach((s,integer) -> {
            if(integer == 1 && !mapA.containsKey(s)) res.add(s);
        });
        return res.toArray(new String[0]);
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
