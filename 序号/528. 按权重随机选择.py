class Solution:

    def __init__(self, w: List[int]):
        n=len(w)
        ps=[0]*n
        ps[0]=w[0]
        for i in range(1,n):
            ps[i]=ps[i-1]+w[i]
        self.n=n
        self.ps=ps

    def pickIndex(self) -> int:
        i = random.randint(1,self.ps[-1])
        return bisect.bisect_left(self.ps,i)