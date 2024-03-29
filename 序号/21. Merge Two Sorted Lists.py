# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
#
# 示例：
#
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
# Definition for singly-linked list.
from queue import PriorityQueue
from queue import Queue


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if (l1.val > l2.val): l1, l2 = l2, l1
            self.mergeTwoLists(l1.next, l2)
        return l1 or l2
    
        # if not list1:
        #     return list2
        # if not list2:
        #     return list1
        # if list1.val>list2.val:
        #     list1,list2=list2,list1
        # list1.next=self.mergeTwoLists(list1.next,list2)
        # return list1



