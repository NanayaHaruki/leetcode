class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        gifts=[-x for x in gifts]
        heapq.heapify(gifts)
        for i in range(k):
            mx = -heapq.heappop(gifts)
            heapq.heappush(gifts,-math.floor(mx**0.5))
        return -sum(gifts)