class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones)==1:return stones[0]
        if len(stones)==2:return abs(stones[0]-stones[1])
        l=[]
        for x in stones:
            heapq.heappush(l,-x)
        while len(l)>1:
            a,b=heapq.heappop(l),heapq.heappop(l)
            c=-abs(a-b)
            if c:
                heapq.heappush(l,c)
        return -l[0] if l else 0