/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @author:xzj
 * @date: 2018/8/1 11:31
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] ascii = new int[128];
        int sum = 0;
        for(int i = 0; i < s.length(); i++) ascii[s.charAt(i)]++;
        int oddCount = 0;
        for(int i = 65; i < 128; i++) {
            int count = ascii[i];
//            char出现偶数次，可以全部当做回文串
            if (count % 2 == 0) {
                sum += count;
            } else {
//                奇数只能加入count-1个。
                oddCount++;
                sum += count - 1;
            }
        }
        return oddCount > 0 ? sum + 1 : sum;
    }
}
