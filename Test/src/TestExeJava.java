import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for(Object o : subdomainVisits(arr)) {
            System.out.println(o);
        }
    }

    static public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            String[] args = domain.split("\\.");
//            题设中，域名包含1或2个.  所以args的长度为2或3
            if (args.length == 2) {
                map.put(args[1],map.getOrDefault(args[1],0)+count);
                map.put(domain,map.getOrDefault(domain,0)+count);
            }else {
                map.put(args[2],map.getOrDefault(args[2],0)+count);
                map.put(args[1]+"."+args[2],map.getOrDefault(args[1]+"."+args[2],0)+count);
                map.put(domain,map.getOrDefault(domain,0)+count);
            }
        }
        return map.entrySet().stream()
                .flatMap((Function<Map.Entry<String, Integer>, Stream<String>>) entry -> Stream.of(entry.getValue()+" " +entry.getKey()))
                .collect(Collectors.toList());
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
