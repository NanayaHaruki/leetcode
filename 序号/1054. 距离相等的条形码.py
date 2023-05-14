import heapq
class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        # 按照次数排序，优先使用剩余最多的数字
        cnts=Counter(barcodes)
        l=[]
        for x,c in cnts.items():
            heapq.heappush(l,(-c,x))
        ans=[]
        while len(l)>=2:
            p1,p2=heapq.heappop(l),heapq.heappop(l)
            ans.append(p1[1])
            ans.append(p2[1])
            if p1[0]<-1:
                heapq.heappush(l,(p1[0]+1,p1[1]))
            if p2[0]<-1:
                heapq.heappush(l,(p2[0]+1,p2[1]))
        if l:
            ans.append(l[0][1])
        return ans