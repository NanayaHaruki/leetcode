class ExamRoom:

    def __init__(self, n: int):
        self.s = []
        self.n = n

    def seat(self) -> int:
        if not self.s:
            cur=0
        else :
            diff,cur = self.s[0],0
            for i in range(len(self.s)):
                if i:
                    curDiff = (self.s[i]-self.s[i-1])//2
                    if curDiff > diff:
                        diff=curDiff
                        cur=self.s[i-1]+curDiff
           
            if self.n-1-self.s[-1]>diff:
                cur = self.n-1
        bisect.insort(self.s,cur)
        return cur


    def leave(self, p: int) -> None:
        self.s.remove(p)