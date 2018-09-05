import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestExeJava {
    public static void main(String[] args) {

    }

    static public String longestWord(String[] words) {
        Arrays.sort(words);
        TreeSet<String> set = new TreeSet<>();
        String res = "";
        for(String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                if(word.length() > res.length()) res = word;
                set.add(word);
            }
        }
        return res;
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
