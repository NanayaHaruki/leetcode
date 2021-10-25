// 开方，省略小数部分  比如x是8  返回2即可
class Solution {
    public int mySqrt(int x) {
        int res=1;
        while(true) {
        	// x接近int最大值的时候，res*res可能会溢出
            if((long)res*res > x) {
                return res-1;
            }
            res++;
        }
    }
}
