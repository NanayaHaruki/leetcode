// 计算小于n的质数数量
class Solution {
    public int countPrimes(int n) {
        // 从2*2开始乘，将合数记录下来
        boolean[] arr = new boolean[n];
        int res = 0;
        for(int i = 2; i < n; i++) {
            // 外层循环碰到false，说明之前的内层循环没有将其变成合数，所以质数+1
            if (!arr[i]) {
                res++;
                for(int j = 2; j * i < n; j++) {
                    // 将数组中的合数设为true
                    arr[i * j] = true;
                }
            }
        }
        return res;
    }
}
