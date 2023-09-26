class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        a,b=time//(n-1),time%(n-1)
        if a&1:
            return n-b
        else:
            return 1+b