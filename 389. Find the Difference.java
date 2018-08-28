/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 * @author:xzj
 * @date: 2018/8/28 16:30
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0,sumT = 0;
//        把每个字符加起来，char当做int处理，差值就是新加的那个char
        for(int i = 0; i < s.length(); i++) sumS += s.charAt(i);
        for(int i = 0; i < t.length(); i++) sumT += t.charAt(i);
        return (char) (sumT - sumS);
    }

//    public char findTheDifference(String s, String t) {
//        int[] ascii = new int[128];
//        for(int i = 0; i < s.length(); i++) ascii[s.charAt(i)]++;
//        for(int i = 0; i < t.length(); i++) ascii[t.charAt(i)]--;
//        for(int i = 65; i < 128; i++) {
////            遍历s的时候，出现几次，ascii[i]就是几，遍历t的时候，出现一次扣一次；
////            遍历t的时候多扣了一次，所以是-1
//            if (ascii[i] == -1) {
//                char c = (char) i;
//                return c;
//            }
//        }
//        return ' ';
//    }


}
