/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * @author:xzj
 * @date: 2018/8/28 16:30
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String regex = " ";
        String[] arr = str.split(regex);
        if(pattern.length() != arr.length) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String valueStr = map.get(c);
                if (!arr[i].equals(valueStr)) return false;
            }else {
//                不包含这个key，却包含value，说明别的key对应了value，不匹配
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
