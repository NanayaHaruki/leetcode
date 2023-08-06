class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if  not head:return None
        if not head.next:return head
        nn=self.swapPairs(head.next.next)
        ans=head.next
        ans.next=head
        head.next=nn
        return ans