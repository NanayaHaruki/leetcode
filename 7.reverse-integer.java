// 保留符号反转数字   -123 -> -321，溢出int范围返回0
class Solution {
    public int reverse(int x) {
        // 溢出int返回0，那用long去接到值去判断就是了
        if(x==0) return 0;
        else if(x>0) {
            long reverse = Long.valueOf(new StringBuilder(Integer.toString(x)).reverse().toString());
            if(reverse > Integer.MAX_VALUE) {
                return 0;
            }else {
                return (int)reverse;
            }
        }else {
            StringBuilder sb = new  StringBuilder(Integer.toString(x)).reverse();
            long reverse = -Long.valueOf((sb.deleteCharAt(sb.length()-1).toString()));
            if(reverse < Integer.MIN_VALUE) {
                return 0;
            }else {
                return (int) reverse;
            }
        }
    }
}
