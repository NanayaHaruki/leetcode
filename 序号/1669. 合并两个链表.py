class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        dump = ListNode(0,list1)
        p=dump
        for i in range(a):
            p=p.next
        start=p
        for i in range(b-a+1):
            p=p.next
        end=p.next
        p=list2
        while p.next:
            p=p.next
        start.next=list2
        p.next=end
        return dump.next