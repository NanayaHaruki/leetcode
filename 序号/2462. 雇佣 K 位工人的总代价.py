class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        q = deque(costs)
        q1,q2=[],[]
        ans=0
        while k:
            while q and len(q1)<candidates:
                heapq.heappush(q1,q.popleft())
            while q and len(q2)<candidates:
                heapq.heappush(q2,q.pop())
            if (q1 and not q2) or (q1 and q2 and q1[0]<=q2[0]):
                ans+=heapq.heappop(q1)
            else:
                ans+=heapq.heappop(q2)
            k-=1
        return ans