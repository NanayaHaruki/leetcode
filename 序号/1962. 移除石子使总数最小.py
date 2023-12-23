class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        l=[]
        for x in piles:
            heapq.heappush(l,-x)
        while k:
            x=-heapq.heappop(l)
            k-=1
            heapq.heappush(l,-x//2)
        return -sum(l)