class Solution:
    def minimumPossibleSum(self, n: int, k: int) -> int:
        # 找一个正整数数组，长度为n。数组中两两之和！=k
        # [1,k-1] 选1;
        # [2,k-2] 选2; 一直能选到 k//2
        # [k//2+1,k-1]都不能选了，如果不够n的长度，从k再开始找后面的
        m=k//2
        a = (1+m)*m//2
        if m>=n:
            return (1+n)*n//2%1000000007
        # 还不够，从k继续选
        b = (k + k+  n-m-1)*(n-m)//2
        return (a+b)%1000000007