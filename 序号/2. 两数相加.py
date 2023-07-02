# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        a,b,c=l1,l2,ListNode()
        j=0
        d=c
        while a or b:
            c.next=ListNode()
            c=c.next
            if a and b:
                c.val=a.val+b.val+j
                if c.val>9:
                    c.val%=10
                    j=1
                else:
                    j=0
            elif a and not b:
                c.val=a.val+j
                if c.val>9:
                    c.val%=10
                    j=1
                else:
                    j=0
            elif not a and b:
                c.val=b.val+j
                if c.val>9:
                    c.val%=10
                    j=1
                else:
                    j=0
            if a:
                a=a.next
            if b:
                b=b.next
        if j:
            c.next=ListNode(1)
        return d.next
            