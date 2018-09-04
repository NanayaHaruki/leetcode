/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 *
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * @author:xzj
 * @date: 2018/8/31 9:05
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = 0;
        Map<String, Integer> map = new HashMap<>();//key存餐厅名称，value存角标
        TreeMap<Integer, ArrayList<String>> ts = new TreeMap<>(); //key 存角标和  value存餐厅名
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
}
