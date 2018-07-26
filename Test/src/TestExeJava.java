import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        switch (rowIndex) {
            case 0:
                result.add(1);
                return result;
            case 1:
                result.add(1);
                result.add(1);
                return result;
            default:
                List<Integer> preList = getRow(--rowIndex);
                result.add(1);
                for(int i = 1; i < preList.size(); i++) {
                    result.add(preList.get(i - 1)+preList.get(i));
                }
                result.add(1);
                break;
        }
        return result;
    }
}
