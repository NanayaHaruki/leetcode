class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        # x0=k*a+b
        # x1=10*x0+1  x1%k=(10*b+1)%k
        # 从1算起，最多重复k次，余数要么重复进入循环，无法整除; 要么出现了0，可以整除
        s=set()
        x=0
        for i in range(k):
            x=(10*x+1)%k
            if x==0:
                return i+1
            if x in s:
                return -1
            s.add(x)
        return -1