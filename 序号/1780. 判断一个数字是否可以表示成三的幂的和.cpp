class Solution {
public:
    bool checkPowersOfThree(int n) {
        // 三进制，不同的幂的和，说明三进制的i位上不能有2（表示需要2个3的i次幂）
        if(n==0) return true;
        return n%3!=2 &&  checkPowersOfThree(n/3);
    }
};