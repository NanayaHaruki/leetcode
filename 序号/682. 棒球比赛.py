class Solution:
    def calPoints(self, operations: List[str]) -> int:
        
        s = []
        for i,x in enumerate(operations):
            if x=='+':
                s.append(s[-1]+s[-2])
            elif x=='D':
                s.append(s[-1]*2)
            elif x=='C':
                s.pop()
            else:
                s.append(int(x))
        return sum(s)