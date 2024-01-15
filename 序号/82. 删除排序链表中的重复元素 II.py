# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        p=dummy = ListNode(-101,head)
        while p.next and p.next.next:
            if p.next.val<p.next.next.val:
                p=p.next
                continue
            v=p.next.val
            while p.next and p.next.val==v:
                p.next=p.next.next
        return dummy.next
    
        


        