/**
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * 杨辉三角 输入行数，返回二维数组
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++) {
            switch (i) {
                case 1:
                    List<Integer> row1 = new ArrayList<>();
                    row1.add(1);
                    result.add(row1);
                    break;
                case 2:
                    List<Integer> row2 = new ArrayList<>();
                    row2.add(1);
                    row2.add(1);
                    result.add(row2);
                    break;
                default:
//                   杨辉三角 第几行就有几个元素
                    List<Integer> rowN = new ArrayList<>();
                    List<Integer> preList = result.get(i - 2);
                    rowN.add(1);
                    for(int j = 1; j < preList.size(); j++) {
                        rowN.add(j, preList.get(j - 1) + preList.get(j));
                    }
                    rowN.add(1);
                    result.add(rowN);
                    break;
            }
        }
        return result;
    }
}