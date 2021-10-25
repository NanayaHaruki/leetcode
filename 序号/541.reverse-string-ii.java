class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += k * 2) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char c = chars[start];
                chars[start++] = chars[end];
                chars[end--] = c;
            }
        }
        return new String(chars);
    }
}
