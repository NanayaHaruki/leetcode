# 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
#
# 示例 1:
#
# 输入: 1->1->2
# 输出: 1->2
# 示例 2:
#
# 输入: 1->1->2->3->3
# 输出: 1->2->3

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        result = head
        while result and result.next:
            if result.val == result.next.val:
                result.next = result.next.next
            else:
                result = result.next
        return head


def createListNode(list) -> ListNode:
    if not list: return None
    res = ListNode(0)
    for x in list:
        res.val = x


if __name__ == '__main__':
    and_ = 1 and 1 / 0
    print(and_)
