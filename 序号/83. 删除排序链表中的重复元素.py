# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        p=fakeHead = ListNode(-101,head)
        while p.next:
            if p.val == p.next.val:
                p.next=p.next.next
            else:
                p=p.next
        return fakeHead.next