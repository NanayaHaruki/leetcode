import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class TestExeJava {
    public static void main(String[] args) {


    }

    static public int getImportance(List<Employee> employees, int id) {
        return findSubImportant(employees, employees.stream().filter(employee -> employee.id == id).findFirst().get().subordinates);
    }

    static int findSubImportant(List<Employee> employees, List<Integer> ids) {
        int res = 0;
        for(Employee employee : employees) {
            if(ids.contains(employee.id))
                res += (employee.importance + findSubImportant(employees, employee.subordinates));
        }
        return res;
    }


    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
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
