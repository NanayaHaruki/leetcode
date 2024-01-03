# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        q=deque()
        p=head
        while p:
            while q and q[-1].val<p.val:
                q.pop()
            q.append(p)
            p=p.next
        fake =ListNode(0,q[0])
        p=fake
        while q:
            p.next=q.popleft()
            p=p.next
        return fake.next
