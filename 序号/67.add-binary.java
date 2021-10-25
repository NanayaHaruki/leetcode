// 给两个二进制字符串，加起来，返回二进制
class Solution {
     public String addBinary(String a, String b) {
//        从个位数开始相加
        int aLastIndex = a.length() - 1;
        int bLastIndex = b.length() - 1;
//        carry是记录每次相加的进位的
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (aLastIndex >= 0 || bLastIndex >= 0) {
            int i = aLastIndex >= 0 ? Character.getNumericValue(a.charAt(aLastIndex--)) : 0;
            int j = bLastIndex >= 0 ? Character.getNumericValue(b.charAt(bLastIndex--)) : 0;
            int sum = i+j+carry;
            sb.append(sum%2); //记录相加的最终结果 保留模  即个位
            carry=sum/2;  //进位是当前位之和除2
        }
        if(carry==1) sb.append("1");
        return sb.reverse().toString();
    }
}
