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

    def join(self, pq: PriorityQueue, listNode: ListNode):

        if listNode is not None:
            pq.put_nowait(listNode.val)
            self.join(pq, listNode.next)

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = None
        def createListNode(pq: PriorityQueue, node: ListNode):
            if not pq.empty():
                if node is None:
                    node = ListNode(pq.get_nowait())
                else:
                    node.val = pq.get_nowait()
                if not pq.empty():
                    node.next = ListNode(0)
                    createListNode(pq, node.next)

        pq = PriorityQueue()
        self.join(pq, l1)
        self.join(pq, l2)

        if pq.empty():
            return None
        res = ListNode(0)
        createListNode(pq, res)
        return res


def printNode(listNode: ListNode):
    if listNode is not None:
        print(listNode.val)
        printNode(listNode.next)


if __name__ == '__main__':
    s = Solution()
    l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next.next = ListNode(3)

    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)

    node = s.mergeTwoLists(l1, l2)
    printNode(node)
