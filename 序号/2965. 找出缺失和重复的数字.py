class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n=len(grid)
        cnts = [0]*(n*n+1)
        for i,x in enumerate(grid):
            for y in x:
                cnts[y]+=1
        a=b=0
        for i,c in enumerate(cnts):
            if c==0:
                b=i
            elif c==2:
                a=i
            if a and b:
                return [a,b]