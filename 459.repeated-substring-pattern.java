// 判断字符串是否由子串重复构成的
// abab  返回true
// aba   返回false
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 如果s可以有子串重复构成，必然至少重复两次，假设重复的子串是a，那么s= a+a
        // 定义一个s2 = s+s = a1+a2+a3+a4
        // 去掉a1，a4（只要去除a1的第一个char和a4的最后一个char），  前一个s的后半部分a2和后一个s的前半部分a3  会重新组合成s
    	String s2 = s+s;
        s2 = s2.substring(1,s2.length()-1);
        return s2.contains(s);
    }
}
