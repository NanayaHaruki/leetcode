class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        a,b=1,0
        while n:
            m=n%10
            n//=10
            a*=m
            b+=m
        return a-b
