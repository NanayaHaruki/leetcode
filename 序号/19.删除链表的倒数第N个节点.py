class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(next=head)
        pre = dummy
        p = head
        q = []
        while p:
            if (len(q) < n):
                q.append(p)
            else:
                pre = q.pop(0)
                q.append(p)
            p = p.next
        if (n == 1):
            pre.next = None
        else:
            pre.next = q[1]
        return dummy.next