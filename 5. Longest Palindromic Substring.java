/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author:xzj
 * @date: 2018/9/19 15:53
 */
class Solution {
    public String longestPalindrome(String s) {
        //        开头加^ 结尾加$， #把字符分隔开，这样在计算回文的时候就只用考虑奇数的问题了。
//        比如奇数回文  aba  ^#a#b#a#$  9个
//        比如偶数回文  aa   ^#a#a#$    7个
//        统统变成奇数回文来考虑
        StringBuilder sb = new StringBuilder("^#");
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i))
                    .append("#");
        }
        sb.append("$");

        String res = null;
        int maxLen = 0;
        for(int i = 1; i < sb.length()-1; i++) {
            int j = 1;
            while (i - j >=0 && i+j <=sb.length()-1) {
                if (sb.charAt(i - j) == sb.charAt(i + j)) {
                    j++;

                }else break;
            }
            j--;
            if (2*j+1 > maxLen) {
                maxLen = 2*j+1;
                res = sb.substring(i - j, i + j + 1);
            }
        }
        return res.replace("#","");
    }
}
