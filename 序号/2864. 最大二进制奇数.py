class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        cnt = 0
        for x in s:
            if x=='1':cnt+=1
        n=len(s)
        return '1'*(cnt-1)+'0'*(n-cnt)+'1'

