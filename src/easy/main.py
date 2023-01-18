import bisect
from typing import List
import heapq
from sortedcontainers import SortedDict
class MKAverage:

    def __init__(self, m: int, k: int):
        self.l =[]
        self.m=m
        self.k=k
        self.sd = SortedDict()
        self.sum=0

    def addElement(self, num: int) -> None:
        if len(self.l)>=self.m:
            item=self.l.pop(0)
            self.sum-=item
            self.sd[item]-=1
            if not self.sd[item]:
                self.sd.pop(item)

        self.sum+=num
        self.l.append(num)
        if item in self.sd:
            self.sd[item]+=1
        else:
            self.sd[item]=1
        


    def calculateMKAverage(self) -> int:
        if len(self.l) <self.m:
            return -1
        ans=sum
        for i in range(self.k):
            ans-=self.sd[i]*min(self.sd)




sd = SortedDict()
sd[3]=33
sd[1]=21
print(sorted(sd,True))