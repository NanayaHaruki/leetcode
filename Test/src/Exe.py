from queue import PriorityQueue







class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def __init__(self):
        print()


    def join(self, pq: PriorityQueue, listNode: ListNode):
        if listNode.val is not None:
            pq.put_nowait(listNode.val)
        while True:
            list_node_next = listNode.next
            if list_node_next is None:
                break
            else:
                pq.put_nowait(list_node_next)

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        def createListNode(pq: PriorityQueue, node: ListNode) -> ListNode:
            if not pq.empty():
                node.val = pq.get_nowait()
                if not pq.empty():
                    createListNode(pq, node.next)
            return node

        pq = PriorityQueue()
        self.join(pq, l1)
        self.join(pq, l2)
        res = ListNode(0)
        createListNode(pq, res)

        return res
