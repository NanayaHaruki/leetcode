// 判断一个数是不是2的幂
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 如果是2的幂的话，其二进制必然是0000010000这样的
        // 比如1   0001 2  0010   4   0100  8  1000
        // 也就是说2的幂的二进制中只能有一个1
        return n<1?false:Integer.bitCount(n)==1;
    }
}
