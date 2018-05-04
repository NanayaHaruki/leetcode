// s为只有0和1组成的字符串，找出拥有同等数量01的子串  01在分组里连续
class Solution {
    public int countBinarySubstrings(String s) {
        // 思路，0001111  存在01 0011 000111  三种，000长度为3  1111长度为4
        // 找出相邻的两组中数量少的长度即为符合条件的子串数量
        int cur = 1, pre = 0, res = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }
}
