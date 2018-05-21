// 判断一个数n是否为快乐数
// 快乐数定义：每位数字的平方相加得到新的数，再讲每位数字平方相加，最后能得到1 
// 比如 7 -> 49 -> 16+81=97 -> 81+49=130 -> 1+9=10 -> 1+0 = 1

class Solution {
    public boolean isHappy(int n) {
        // 查询wiki后发现10以下的快乐数只有1和7
        if(n < 10) {
        	if(n == 1 || n == 7) return true;
        	else return false;
        }
        int i,sum = 0;
        while(n > 0) {
        	i = n%10;
        	sum += i*i;
        	n/=10;
        }
        return isHappy(sum);
    }
}
