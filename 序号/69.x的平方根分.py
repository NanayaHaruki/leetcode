class Solution:
    def mySqrt(self, x: int) -> int:
        '''算术平方根'''
        if x==1:
            return 1
        l,r=1,x//2
        while l<=r:
            m=(l+r)//2
            mm = m*m
            if mm==x:
                return m
            elif mm>x:
                r=m-1
            else:
                l=m+1
        return r