// 将一句话中的单词反转
class Solution {
   public String reverseWords(String s) {
        String regex = " ";
        String[] words = s.split(regex);
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            if (sb.length() == 0) {
                sb.append(new StringBuilder(word).reverse());
            } else {
                sb.append(" ").append(new StringBuilder(word).reverse());
            }
        }
        return sb.toString();
    }
}
