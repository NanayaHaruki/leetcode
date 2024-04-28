class Solution:
    def baseNeg2(self, n: int) -> str:
        if n==0:
            return '0'
        if n==1:
            return '1'
        x = self.baseNeg2((n-1)//-2)
        return x+'1' if n&1 else x+'0'
        