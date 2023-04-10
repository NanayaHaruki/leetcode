class Solution:
    def nextLargerNodes(self, head: Optional[ListNode]) -> List[int]:
        ns = []
        while head:
            ns.append(head.val)
            head=head.next
        ans=[0]*len(ns)
        q=[]
        for i in range(len(ns)-1,-1,-1):
            while q and q[0]<=ns[i]:
                heapq.heappop(q)
            ans[i]=q[0] if q and q[0]>ns[i] else 0
            heapq.heappush(q,ns[i])
        return ans