class Solution:
    def removeTrailingZeros(self, num: str) -> str:
        n = len(num)-1
        while n>=0 and num[n]=='0':
            n-=1
        return num[:n+1]