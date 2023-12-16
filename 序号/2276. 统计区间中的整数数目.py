from sortedcontainers import SortedSet
class CountIntervals:

    def __init__(self):
        self.cnt=0
        self.ss = SortedSet([(0,10**9+1,0)])
        

    def split(self,x):
            ss=self.ss
            idx = bisect.bisect_right(ss,(x,0))-1
            if ss[idx][0]==x:return idx
            l,r,v=ss[idx]
            ss.pop(idx)
            ss.add((l,x-1,v))
            ss.add((x,r,v))
            return idx+1
    def add(self, left: int, right: int) -> None:
        r,l=self.split(right+1),self.split(left)
        idx=bisect.bisect_left(self.ss,(left,0,0))
        while self.ss[idx][1]<right+1:
            start,end,value=self.ss[idx]
            if value:
                self.cnt-=end-start+1
            self.ss.pop(idx)
        self.ss.add((left,right,1))
        self.cnt+=right-left+1

    def count(self) -> int:
        return self.cnt