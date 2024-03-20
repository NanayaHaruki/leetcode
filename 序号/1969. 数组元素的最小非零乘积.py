class Solution:
    def minNonZeroProduct(self, p: int) -> int:
        # 尽量将更多的数变成1
        # p = 3时，数字有 001 010 011 100 101 110 111
        # 可以看到，2^p-1一定是个奇数，且除了7之外，其他数两两配对可以交换成1和6
        # 比如2和5 010 101，二进制互补，将2低2位的10与5的01互换，2和5就变成了1和6
        # 可以交换 7//2次，总共的最小积为 7 * 6**(7//2)
        def pow(x,n):
            ans=1
            x%=mod
            while n:
                if n&1:
                    ans=ans*x%mod
                x=x*x%mod
                n>>=1
            return ans%mod

        mod = 1_000_000_007
        a = (1<<p)-1
        return a * pow(a-1,a//2) % mod