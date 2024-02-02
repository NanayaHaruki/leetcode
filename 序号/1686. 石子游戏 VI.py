class Solution:
    def stoneGameVI(self, aliceValues: List[int], bobValues: List[int]) -> int:
        n=len(aliceValues)
        t=[[0]*2]*n
        for i in range(n):
            t[i]=aliceValues[i]+bobValues[i],i
        t.sort(reverse=True)
        a=b=0
        for i,x in enumerate(t):
            if i&1:
                b+=bobValues[x[1]]
            else:
                a+=aliceValues[x[1]]
        if a>b:return 1
        if a<b:return -1
        return 0