  // 1 -> A
    // 2 -> B
    // 3 -> C
    // ...
    // 26 -> Z
    // 27 -> AA
    // 28 -> AB
class Solution {
    public int titleToNumber(String s) {
        // 这其实就是26进制
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - 1 - i);
            res += Math.pow(26, i) * (c - 'A' + 1);
        }
        return res;
    }
}
