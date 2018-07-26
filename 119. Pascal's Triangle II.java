/**
 * 返回杨辉三角第rowIndex行的数据
 * @author:xzj
 * @date: 2018/7/26 15:05
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
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