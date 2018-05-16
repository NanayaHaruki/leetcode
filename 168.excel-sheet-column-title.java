    // 1 -> A
    // 2 -> B
    // 3 -> C
    // ...
    // 26 -> Z
    // 27 -> AA
    // 28 -> AB
class Solution {
   public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
