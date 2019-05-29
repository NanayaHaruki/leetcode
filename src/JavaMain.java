import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: taoye
 * @Description:
 * @Date: 13:20 2019/2/18
 */
public class JavaMain {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1.1);
        map.put("b", 1);
        System.out.println(map.get("a") instanceof Double);
        System.out.println(map.get("a") instanceof Integer);
        System.out.println(map.get("b") instanceof Double);
        System.out.println(map.get("b") instanceof Integer);
        System.out.println(Integer.parseInt("1.1"));


    }
}
