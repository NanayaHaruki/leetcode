ListNode.__lt__=lambda a,b:a.val<b.val
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        d=[]
        for h in lists:
            if h:
                heapq.heappush(d,h)
        p=fake = ListNode(0)
        while d:
            top = heapq.heappop(d)
            p.next=top
            p=top
            if top.next:
                heapq.heappush(d,top.next)
        return fake.next