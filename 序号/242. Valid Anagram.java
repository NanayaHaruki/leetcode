/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author:xzj
 * @date: 2018/8/28 16:30
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ascii = new int[128];
        for(int i = 0; i < s.length(); i++) ascii[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++) ascii[t.charAt(i)]--;
        for(int i = 65; i < 128; i++) {
            if(ascii[i] != 0) return false;
        }
        return true;
    }
}
