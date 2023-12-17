# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:return None
        p = head
        n=0
        while p:
            n+=1
            p=p.next
        k%=n
        if k==0:return head
        q=deque()
        p=head
        pre=None
        while p:
            if len(q)<k:
                q.append(p)
            else:
                pre=q.popleft()
                q.append(p)
            p=p.next
        if pre:
            pre.next=None
        q[-1].next=head
        return q[0]